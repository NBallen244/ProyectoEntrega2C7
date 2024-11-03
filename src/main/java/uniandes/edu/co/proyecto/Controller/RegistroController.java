package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.modelo.Orden;
import uniandes.edu.co.proyecto.modelo.ProductosOrden;
import uniandes.edu.co.proyecto.modelo.Registro;
import uniandes.edu.co.proyecto.repositorio.AlmacenajeRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenRepository;
import uniandes.edu.co.proyecto.repositorio.ProductosOrdenRepository;
import uniandes.edu.co.proyecto.repositorio.RegistroRepository;


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

    @GetMapping("/registros")
    public ResponseEntity<Collection<Registro>> registros() {
        try {
            Collection<Registro> registros = registroRepository.darRegistros();
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/registros/new/save")
    public ResponseEntity<?> registroGuardar(@RequestBody Registro registro) {
        try {
            registroRepository.sinAutoCommit();
            Date hoy= new Date(System.currentTimeMillis());
            Orden ordenAsociada = ordenRepository.darOrden(registro.getOrden().getId());
            //*Revisamos que los datos de la orden sean correctos con respecto a los del ingreso */
            if (ordenAsociada == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden no existe");
            }
            else if(ordenAsociada.getSucursal_destino().getId() != registro.getBodega().getSucursal().getId()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La bodega no pertenece a la sucursal de destino de la orden");
            }
            else if (ordenAsociada.getEstado().equals("entregada")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden ya fue entregada");
                
            }
            else if (ordenAsociada.getEstado().equals("anulada")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La orden fue anulada");
            }
            else if (registro.getFechaIngreso().before(ordenAsociada.getFecha_creacion()) || registro.getFechaIngreso().before(hoy)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha de ingreso no puede ser anterior a la fecha de creacion de la orden y/o la actual");
            }
            registroRepository.insertarRegistro(registro.getOrden().getId(), registro.getFechaIngreso(), registro.getBodega().getId());
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
                    registroRepository.anular();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La cantidad de productos en la bodega excede el limite de capacidad de esta");
                }
                Long nuevoprecioProm=(cantidadActual*precioActual+productoOrden.getCantidad()*productoOrden.getPrecio_acordado())/(cantidadActual+productoOrden.getCantidad());
                almacenajeRepository.actualizarConIngreso(bodega, producto, nuevacantidad, nuevoprecioProm);
                }
            }
            ordenRepository.actualizarOrdenEntregada(ordenAsociada.getId());
            registroRepository.confirmar();
            return ResponseEntity.status(HttpStatus.CREATED).body("Registro de ingreso exitoso");
        } catch (Exception e) {
            registroRepository.anular();
            return new ResponseEntity<>("Error al ingresar productos a la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
