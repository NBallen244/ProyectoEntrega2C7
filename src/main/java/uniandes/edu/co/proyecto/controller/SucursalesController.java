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

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
public class SucursalesController {
    
    @Autowired
    private SucursalRepository sucursalRepository;


    @GetMapping("/sucursales")
    public ResponseEntity<Collection<Sucursal>> sucursales() {
        try {
            Collection<Sucursal> sucursales = sucursalRepository.darSucursales();
            return ResponseEntity.ok(sucursales);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(sucursal.getNombre(), sucursal.getTamaño(), sucursal.getCiudad(), sucursal.getTelefono(), sucursal.getDireccion());
            return new ResponseEntity<>("Sucursal creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la Sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sucursales/{id}/edit/save")
    public ResponseEntity<String> sucursalEditarGuardar(@PathVariable("id") long id, @RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.actualizarSucursal(id, sucursal.getNombre(), sucursal.getCiudad(), sucursal.getTamaño(), sucursal.getTelefono(), sucursal.getDireccion());
            return new ResponseEntity<>("Sucursal actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sucursales/{id}/delete")
    public ResponseEntity<String> sucursalEliminar(@PathVariable("id") long id) {
        try {
            sucursalRepository.eliminarSucursal(id);
            return new ResponseEntity<>("Sucursal eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
