package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Repositorio.OrdenRepository;
import uniandes.edu.co.proyecto.modelo.Orden;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping("/ordenes")
    public Collection<Orden> getOrdenes() {
        return ordenRepository.darOrdenes();
    }

    @PostMapping("/ordenes/new/save")
    public ResponseEntity<String> ordenGuardar(@RequestBody Orden norden) {
        try{
            ordenRepository.insertarOrden(norden.getEstado(), norden.getFechaEstimada(), norden.getFechaLlegada(), norden.getFechaCreacion(), norden.getProveedor(), norden.getBodegaDestino());
            return new ResponseEntity<>("Orden creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear la orden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping("/ordenes/{id}/edit/save")
    public ResponseEntity<String> ordenEditarGuardar(@PathVariable("id")Long id, @RequestBody Orden orden){
        try{
            ordenRepository.actualizarOrden(id, orden.getEstado(), orden.getFechaEstimada(), orden.getFechaLlegada(), orden.getFechaCreacion(), orden.getProveedor(), orden.getBodegaDestino());
            return new ResponseEntity<>("Orden actualizada exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la orden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordenes/{id}/delete")
    public ResponseEntity<String> ordenEliminar(@PathVariable("id") Long id) {
        try{
            ordenRepository.eliminarOrden(id);
            return new ResponseEntity<>("Orden eliminada exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al eliminar la orden", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    


}
