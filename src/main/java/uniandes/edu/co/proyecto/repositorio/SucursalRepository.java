package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    @Query(value = "SELECT * FROM sucursales", nativeQuery = true)
    Collection<Sucursal> darSucursales();

    @Query(value = "SELECT * FROM sucursales WHERE id = :id", nativeQuery = true)
    Sucursal darSucursal(@Param("id") int id);

    /*RFC4 */
    @Query(value = "SELECT * FROM sucursales INNER JOIN bodegas ON bodegas.sucursal=sucursales.id INNER JOIN almacenajes on bodegas.id=almacenajes.bodega WHERE almacenajes.producto = :producto", nativeQuery = true)
    Collection<Sucursal> darSucursalesConProducto(@Param("producto") long producto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursales (id, nombre, tamaño, ciudad, telefono, direccion) VALUES ( paso.nextval , :nombre, :tamaño, :ciudad, :telefono, :direccion)", nativeQuery = true)
    void insertarSucursal(@Param("nombre") String nombre, @Param("tamaño") Long tamaño, @Param("ciudad") Long ciudad,
    @Param("telefono") Long telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursales SET nombre = :nombre, ciudad = :ciudad, tamaño = :tamaño, telefono = :telefono, direccion = :direccion WHERE id = :id", nativeQuery = true)
    void actualizarSucursal(@Param("id") long id, @Param("nombre") String nombre, @Param("ciudad") Long ciudad,
    @Param("tamaño") Long tamaño, @Param("telefono") Long telefono, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursales WHERE id = :id", nativeQuery = true)
    void eliminarSucursal(@Param("id") long id);

}
