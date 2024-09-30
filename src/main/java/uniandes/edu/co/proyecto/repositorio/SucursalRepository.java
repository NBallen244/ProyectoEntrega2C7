package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    @Query(value = "SELECT * FROM sucursales WHERE id = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (id, nombre, tamaño, ciudad, telefono, direccion) VALUES ( proyecto_sequence.nextval , :nombre, :tamaño, :ciudad, :telefono, :direccion)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamaño") Integer tamaño, @Param("ciudad") Integer ciudad,
    @Param("telefono") Integer telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursales SET nombre = :nombre, ciudad = :ciudad, tamaño = :tamaño, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") long id, @Param("nombre") String nombre, @Param("ciudad") Integer ciudad,
    @Param("tamaño") Integer tamaño, @Param("telefono") Integer telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursales WHERE id = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") long id);

}
