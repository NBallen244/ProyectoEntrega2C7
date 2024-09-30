package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // Le falta incluir direccion
    @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    Proveedor darProveedor(@Param("nit") int nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedores (nit, nombre, contacto, tel_contacto, direccion) VALUES ( :nit , :nombre, :contacto, :tel_contacto, :direccion)", nativeQuery = true)
    void insertarProveedor(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("contacto") String contacto,
    @Param("tel_contacto") Long tel_contacto, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores SET nombre = :nombre, contacto = :contacto, tel_contacto = :tel_contacto, direccion = :direccion WHERE nit = :nit", nativeQuery = true)
    void actualizarProveedor(@Param("nit") Long nit, @Param("nombre") String nombre, @Param("contacto") String contacto,
    @Param("tel_contacto") Long tel_contacto, @Param("direccion") String direccion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proveedores WHERE nit = :nit", nativeQuery = true)
    void eliminarProveedor(@Param("nit") Long nit);
}
