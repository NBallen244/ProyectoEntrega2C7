package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductosOrden;
import uniandes.edu.co.proyecto.modelo.ProductosOrdenPK;

public interface ProductosOrdenRepository extends JpaRepository<ProductosOrden, ProductosOrdenPK>{
    @Query(value = "SELECT * FROM productosOrden", nativeQuery = true)
        Collection<ProductosOrden> darProductosOrdens();

    
    @Query(value = "SELECT * FROM productosOrden WHERE orden = :orden AND producto = :producto", nativeQuery = true)
    ProductosOrden darProductosOrden(@Param("orden") Long orden, @Param("producto") Long producto);

    @Query(value = "SELECT * FROM productosOrden WHERE orden = :orden", nativeQuery = true)
    Collection<ProductosOrden> darProductosXOrden(@Param("orden") Long orden);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productosOrden WHERE orden = :orden AND producto = :producto", nativeQuery = true)
    void eliminarProductosOrden(@Param("orden") Long orden, @Param("producto") Long producto);

    

    @Modifying
    @Transactional
    @Query(value = "UPDATE productosOrden SET cantidad = :cantidad, precio_acordado = :precio_acordado WHERE orden = :orden AND producto = :producto", nativeQuery = true)
    void actualizarProductosOrden(@Param("orden") Long orden, @Param("producto") Long producto, @Param("cantidad") Long cantidad, @Param("precio_acordado") Long precio_acordado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productosOrden (orden, producto, cantidad, precio_acordado) VALUES ( :orden, :producto, :cantidad, :precio_acordado)", nativeQuery = true)
    void insertarProductosOrden(@Param("orden") Long orden, @Param("producto") Long producto, @Param("cantidad") Long cantidad, @Param("precio_acordado") Long precio_acordado);
}