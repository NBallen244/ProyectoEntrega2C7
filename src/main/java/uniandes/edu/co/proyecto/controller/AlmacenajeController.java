package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.repositorio.AlmacenajeRepository;

public class AlmacenajeController {
    @Autowired
    private AlmacenajeRepository almacenajeRepository;

    @GetMapping("/almacenajes")
    public ResponseEntity<Collection<Almacenaje>> almacenajes() {
        try {
            Collection<Almacenaje> almacenajes = almacenajeRepository.darAlmacenajes();
            return ResponseEntity.ok(almacenajes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/almacenajes/new/save")
    public ResponseEntity<?> almacenajeGuardar(@RequestBody Almacenaje almacenaje) {
        try {
            almacenajeRepository.insertarAlmacenaje(almacenaje.getPk().getBodega().getId(), almacenaje.getPk().getProducto().getCodigoBarras(), almacenaje.getCantidad(), almacenaje.getCapacidad(), almacenaje.getCosto_promedio(),almacenaje.getNivel_minimo());
            return ResponseEntity.status(HttpStatus.CREATED).body("Registro de producto de bodega creado exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la almacenaje", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/almacenajes/{id}/edit/save")
    public ResponseEntity<?> almacenajeEditarGuardar(@PathVariable("bodega") Integer bodega, @PathVariable("producto") Integer producto, @RequestBody Almacenaje almacenaje) {
        try {
            almacenajeRepository.actualizarAlmacenaje(almacenaje.getPk().getBodega().getId(), almacenaje.getPk().getProducto().getCodigoBarras(), almacenaje.getCantidad(), almacenaje.getCapacidad(), almacenaje.getCosto_promedio(),almacenaje.getNivel_minimo());
            return ResponseEntity.ok("Almacenaje actualizada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al editar la información de almacenaje", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/almacenajes/{id}/delete")
    public ResponseEntity<?> almacenajeBorrar(@PathVariable("bodega") Integer bodega, @PathVariable("producto") Integer producto) {
        try {
            almacenajeRepository.eliminarAlmacenaje(bodega, producto);
            return ResponseEntity.ok("Producto eliminado de la bodega exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto de la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
