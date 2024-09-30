package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Repositorio.OfertaRepository;
import uniandes.edu.co.proyecto.modelo.Oferta;
import uniandes.edu.co.proyecto.modelo.OfertaPK;

@RestController
public class OfertaController {

    @Autowired
    private OfertaRepository ofertaRepository;

    @GetMapping("/ofertas")
    public Collection<Oferta> getOrdenes() {
        return ofertaRepository.darOfertas();
    }

    @PostMapping("/ofertas/new/save")
    public ResponseEntity<String> ofertaGuardar(@RequestBody Oferta oferta) {
        try{
            OfertaPK pk = oferta.getPk();
            ofertaRepository.insertarOferta(pk.getProveedor(), pk.getProducto());
            return new ResponseEntity<>("Oferta creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear la oferta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/ofertas/{id}/edit/save")
    public ResponseEntity<String> ofertaEditarGuardar(@PathVariable("id")Long id, @RequestBody Oferta oferta){
        try{
            OfertaPK pk = oferta.getPk();
            ofertaRepository.actualizarOferta(id, pk.getProveedor(), pk.getProducto());
            return new ResponseEntity<>("Oferta actualizada exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar la oferta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ofertas/{id}/delete")
    public ResponseEntity<String> ofertaEliminar(@PathVariable("id") Long id) {
        try{
            ofertaRepository.eliminarOferta(id);
            return new ResponseEntity<>("Oferta eliminada exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al eliminar la oferta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
