package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
    @Query(value = "SELECT * FROM bodegas", nativeQuery = true)
    Collection<Bodega> darBodegas();

    
    @Query(value = "SELECT * FROM bodegas WHERE id = :id", nativeQuery = true)
    Bodega darBodega(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE id = : id", nativeQuery = true)
    void eliminarBodega(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE sucursal = :sucursal", nativeQuery = true)
    void eliminarBodegaPorSucursal(@Param("sucursal") Integer sucursal);


    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre = :nombre, tamaño = :tamaño, sucursal = :sucursal WHERE id = :id", nativeQuery = true)
    void actualizarBodega(@Param("nombre") String nombre, @Param("tamaño") Integer tamaño, @Param("sucursal") Integer sucursal);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas (id, nombre, tamaño, sucursal) VALUES ( paso.nextval , :nombre, :tamaño, :sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamaño") Integer tamaño, @Param("sucursal") Integer sucursal);
}
