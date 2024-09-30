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

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public Collection<Producto> getProductos() {
        return productoRepository.darProductos();
    }

     @PostMapping("/productos/new/save")
    public ResponseEntity<String> productoGuardar(@RequestBody Producto producto) {
        try{
            productoRepository.insertarProducto(producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getPeso(),  producto.getVolumen(), producto.getUnidadMedida(), producto.getCantidadPresentacion(),  producto.getFechaVencimiento(), producto.getCategoria().getCodigo());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/{id}/edit/save")
    public ResponseEntity<String> ordenEditarGuardar(@PathVariable("id")Long id, @RequestBody Producto producto){
        try{
            productoRepository.actualizarProducto(id, producto.getNombre(), producto.getCostoBodega(), producto.getPrecioUnitario(), producto.getPresentacion(), producto.getPeso(),  producto.getVolumen(), producto.getUnidadMedida(), producto.getCantidadPresentacion(),  producto.getFechaVencimiento(), producto.getCategoria().getCodigo());
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productos/{id}/delete")
    public ResponseEntity<String> productoEliminar(@PathVariable("id") Long id) {
        try{
            productoRepository.eliminarProducto(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
