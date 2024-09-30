package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.modelo.Producto;


public interface ProductoRepository extends JpaRepository <Producto, Integer>{

    @Query(value = "SELECT * FROM productos", nativeQuery=true )
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE id= :id", nativeQuery=true)
    Producto darProducto(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (nombre, costo_bodega, precio_unitario, presentacion, peso,  volumen, unidad_medida, cantidad_presentacion,  fecha_vencimiento, categoria) VALUES(proyecto_sequence.nextval, :nombre, :costo_bodega, :precio_unitario, :presentacion, :peso,  :volumen, :unidad_medida, :cantidad_presentacion,  :fecha_vencimiento, :categoria)",  nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo_bodega") Integer costo_bodega, @Param("precio_unitario") Integer precio_unitario, 
    @Param("presentacion") String presentacion, @Param("peso") Integer peso, @Param("volumen") Integer volumen, @Param("unidad_medida") String unidad_medida, 
    @Param("cantidad_presentacion") Integer cantidad_presentacion, @Param("fecha_vencimiento") Date fecha_vencimiento, @Param("categoria") Integer categoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, costo_bodega=:costo_bodega, precio_unitario=:precio_unitario, presentacion=:presentacion, peso=:peso,  volumen=:volumen, unidad_medida=:unidad_medida, cantidad_presentacion=:cantidad_presentacion,  fecha_vencimiento=:fecha_vencimiento, categoria=:categoria WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Long id, @Param("nombre") String nombre, @Param("costo_bodega") Integer costo_bodega, @Param("precio_unitario") Integer precio_unitario, 
    @Param("presentacion") String presentacion, @Param("peso") Integer peso, @Param("volumen") Integer volumen, @Param("unidad_medida") String unidad_medida, 
    @Param("cantidad_presentacion") Integer cantidad_presentacion, @Param("fecha_vencimiento") Date fecha_vencimiento, @Param("categoria") Integer categoria);

    @Modifying
    @Transactional
    @Query(value = "DELET FROM productos WHERE id = :id", nativeQuery = true)
    void eliminarProducto(@Param("id") Long id);
}
