package uniandes.edu.co.proyecto.Controller;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Orden;
import uniandes.edu.co.proyecto.modelo.Registro;
import uniandes.edu.co.proyecto.Repositorio.RegistroRepository;


@RestController
public class RegistroController {
    @Autowired
    private RegistroRepository registroRepository;

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
            registroRepository.insertarRegistro(registro.getRegistroPK().getOrdenDeCompra().getId(), registro.getFechaIngreso(), registro.getSucursal().getId(), registro.getBodega().getId(), registro.getProveedor().getNIT());;
            return ResponseEntity.status(HttpStatus.CREATED).body("Bodega creada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
