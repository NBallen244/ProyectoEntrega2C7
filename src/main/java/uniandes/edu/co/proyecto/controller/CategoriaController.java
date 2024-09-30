package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;

public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public ResponseEntity<Collection<Categoria>> categorias() {
        try {
            Collection<Categoria> categorias = categoriaRepository.darCategorias();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/categorias/new/save")
    public ResponseEntity<?> categoriaGuardar(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.insertarCategoria(categoria.getNombre(), categoria.getDescripcion(), categoria.getCaracteristicas());
            return ResponseEntity.status(HttpStatus.CREATED).body("Categoria creada exitosamente");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*TODO consulta categoria por id o nombre */

}