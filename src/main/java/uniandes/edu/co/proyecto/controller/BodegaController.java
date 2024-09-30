package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

public class BodegaController {
    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/bodegas")
    public ResponseEntity<Collection<Bodega>> bodegas() {
        try {
            Collection<Bodega> bodegas = bodegaRepository.darBodegas();
            return ResponseEntity.ok(bodegas);
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
    public ResponseEntity<?> bodegaBorrar(@PathVariable("id") Integer id) {
        try {
            bodegaRepository.eliminarBodega(id);
            return ResponseEntity.ok("Bodega eliminada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
