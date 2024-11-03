package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.Repositorio.CiudadRepository;

@RestController
public class CiudadController {
    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/ciudades")
    public ResponseEntity<Collection<Ciudad>> ciudades() {
        try {
            Collection<Ciudad> ciudades = ciudadRepository.darCiudades();
            return ResponseEntity.ok(ciudades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/ciudades/new/save")
    public ResponseEntity<?> ciudadGuardar(@RequestBody Ciudad ciudad) {
        try {
            Collection<Ciudad> ciudadExistente = ciudadRepository.darCiudadNombre(ciudad.getNombre());
            if (!ciudadExistente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("La ciudad ya existe");
            }
            ciudadRepository.insertarCiudad(ciudad.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body("Ciudad creada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
