package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Oferta;
import uniandes.edu.co.proyecto.modelo.OfertaPK;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.OfertaRepository;

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
            ofertaRepository.insertarOferta(pk.getProveedor().getNIT(), pk.getProducto().getCodigoBarras());
            return new ResponseEntity<>("Oferta creada exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear la oferta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }


    @GetMapping("/ofertas/{id}/delete")
    public ResponseEntity<String> ofertaEliminar(@PathVariable("proveedor") Proveedor proveedor, @PathVariable("producto") Producto producto) {
        try{
            ofertaRepository.eliminarOferta(proveedor, producto);
            return new ResponseEntity<>("Oferta eliminada exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al eliminar la oferta", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
