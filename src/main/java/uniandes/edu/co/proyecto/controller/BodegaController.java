package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Orden;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenRepository;
import uniandes.edu.co.proyecto.repositorio.AlmacenajeRepository;
import uniandes.edu.co.proyecto.repositorio.AlmacenajeRepository.RespuestaIndiceOcupacion;

@RestController
public class BodegaController {
    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private AlmacenajeRepository almacenajeRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/bodegas")
    public ResponseEntity<Collection<Bodega>> bodegas() {
        try {
            Collection<Bodega> bodegas = bodegaRepository.darBodegas();
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*RFC1 */
    @GetMapping("/bodegas/indiceOcupacionPorProducto/{sucursal}")
    public ResponseEntity<?> bodegasIndices(@PathVariable("sucursal") Long sucursalgaid) {
        try {
            Collection<RespuestaIndiceOcupacion> bodegas = almacenajeRepository.darIndiceOcupacion(sucursalgaid);
            return ResponseEntity.ok(bodegas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*RFC3 */
    @GetMapping("/bodegas/{id}/inventario")
    public ResponseEntity<?> bodegaInventario(@PathVariable("id") Long id) {
        try {
            Collection<Almacenaje> inventario = bodegaRepository.darInventario(id);
            Bodega bodega=bodegaRepository.darBodega(id);
            Map<String, Object> response = new HashMap<>();
            response.put("bodega", bodega);
            response.put("inventario", inventario);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<?> bodegaGuardar(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamaño(), bodega.getSucursal().getId());
            return ResponseEntity.status(HttpStatus.CREATED).body("Bodega creada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<?> bodegaBorrar(@PathVariable("id") Long id) {
        try {
            Collection<Orden> ordenesBodega=ordenRepository.darOrdenesXbodegaVigentes(id);
            if (ordenesBodega.size()==0){bodegaRepository.eliminarBodega(id);
            return ResponseEntity.ok("Bodega eliminada exitosamente");}
            else{return new ResponseEntity<>("No se puede eliminar la bodega-ordenes de compra pendientes", HttpStatus.INTERNAL_SERVER_ERROR);}
            
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
