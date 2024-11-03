package uniandes.edu.co.proyecto.controller;

import java.util.Date;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Orden;
import uniandes.edu.co.proyecto.modelo.ProductosOrden;
import uniandes.edu.co.proyecto.modelo.Registro;
import uniandes.edu.co.proyecto.repositorio.AlmacenajeRepository;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenRepository;
import uniandes.edu.co.proyecto.repositorio.ProductosOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.RegistroRepository;

import java.sql.SQLException;


@RestController
public class RegistroController {
    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private AlmacenajeRepository almacenajeRepository;

    @Autowired
    private ProductosOrdenRepository productosOrdenRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/registros")
    public ResponseEntity<Collection<Registro>> registros() {
        try {
            Collection<Registro> registros = registroRepository.darRegistros();
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/registros/serial")
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = SQLException.class)
    public ResponseEntity<Collection<Registro>> registros30Serial() throws SQLException {
        try {
            Calendar fecha = Calendar.getInstance();
            fecha.add(Calendar.DAY_OF_MONTH, -30);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInput=df.format(fecha.getTime());
            Thread.sleep(60*1000);
            Collection<Registro> registros = registroRepository.registrosMesSR(fechaInput);
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            throw new SQLException("Error en la lectura de los registros");
        }
    }

    @GetMapping("/registros/committed")
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
    public ResponseEntity<Collection<Registro>> registros30Commited() throws SQLException {
        try {
            Calendar fecha = Calendar.getInstance();
            fecha.add(Calendar.DAY_OF_MONTH, -30);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInput=df.format(fecha.getTime());
            Thread.sleep(60*1000);
            Collection<Registro> registros = registroRepository.registrosMesRC(fechaInput);
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            throw new SQLException("Error en la lectura de los registros");
        }
    }
    
    @PostMapping("/registros/new/save")
    @Transactional(rollbackFor = SQLException.class)
    public ResponseEntity<?> registroGuardar(@RequestBody Registro registro, @RequestParam(required = true) Long orden) throws SQLException {
        try {
            Date hoy= new Date(System.currentTimeMillis());
            Orden ordenAsociada = ordenRepository.darOrden(orden);
            Bodega bodegaAsociada = bodegaRepository.darBodega(registro.getBodega().getId());
            //*Revisamos que los datos de la orden sean correctos con respecto a los del ingreso */
            if (ordenAsociada == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no existe");
            }
            else if(ordenAsociada.getSucursal_destino().getId() != bodegaAsociada.getSucursal().getId()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La bodega no pertenece a la sucursal de destino de la orden");
            }
            else if (ordenAsociada.getEstado().equals("entregada")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden ya fue entregada");
                
            }
            else if (ordenAsociada.getEstado().equals("anulada")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden fue anulada");
            }
            else if (registro.getFecha_ingreso().before(ordenAsociada.getFecha_creacion()) || registro.getFecha_ingreso().after(hoy)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha de ingreso no puede ser anterior a la fecha de creacion de la orden ni posterior a la actual");
            }
            registroRepository.insertarRegistro(orden, registro.getFecha_ingreso(), registro.getBodega().getId());
            Long bodega=registro.getBodega().getId();

            //**Agregamos cada producto a la bodega seleccionada */
            Collection<ProductosOrden> productosOrden = productosOrdenRepository.darProductosXOrden(ordenAsociada.getId());
            for (ProductosOrden productoOrden : productosOrden) {
                Long producto=productoOrden.getPk().getProducto().getCod_barras();
                /**Si el producto no se almacenaba antes en esta bodega, se registra por primera vez con una capacidad 
                 * inicial de 100000 unidades (eleccion arbitraria por falta de mención en el enunciado)
                **/
                Almacenaje datosProducto = almacenajeRepository.darAlmacenaje(bodega, producto);
                if (datosProducto == null) {
                    almacenajeRepository.insertarAlmacenaje(bodega, producto, 100000L, productoOrden.getCantidad(), productoOrden.getPrecio_acordado(), productoOrden.getCantidad());
                }
                else{
                /** Si ya se habia guardado con un limite establecido, se actualiza el precio y cantidad en bodega solo si no supera
                 * la capacidad de la misma. De lo contrario se aborta.
                 */
                Long cantidadActual= datosProducto.getCantidad();
                Long precioActual=datosProducto.getCosto_promedio();
                Long nuevacantidad=cantidadActual+productoOrden.getCantidad();
                if (nuevacantidad>datosProducto.getCapacidad()) {
                    throw new SQLException(String.format("La cantidad de productos %d a ingresar supera la capacidad de la bodega %d", producto, bodega));
                }
                Long nuevoprecioProm=(cantidadActual*precioActual+productoOrden.getCantidad()*productoOrden.getPrecio_acordado())/(cantidadActual+productoOrden.getCantidad());
                almacenajeRepository.actualizarConIngreso(bodega, producto, nuevacantidad, nuevoprecioProm);
                }
            }
            ordenRepository.actualizarOrdenEntregada(ordenAsociada.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Registro de ingreso exitoso");
        } catch (Exception e) {
            throw new SQLException("Error en al registrar el ingreso");
        }
    }
}
