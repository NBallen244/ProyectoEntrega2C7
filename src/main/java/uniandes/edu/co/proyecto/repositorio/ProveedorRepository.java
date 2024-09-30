package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // Le falta incluir direccion
    @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    Proveedor darProveedor(@Param("nit") int nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedores (nit, nombre, contacto, tel_contacto) VALUES ( :nit , :nombre, :contacto, :tel_contacto)", nativeQuery = true)
    void insertarProveedor(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("contacto") String contacto,
    @Param("tel_contacto") Integer tel_contacto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores SET nombre = :nombre, contacto = :contacto, tel_contacto = :tel_contacto WHERE nit = :nit", nativeQuery = true)
    void actualizarProveedor(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("contacto") String contacto,
    @Param("tel_contacto") Integer tel_contacto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proveedores WHERE nit = :nit", nativeQuery = true)
    void eliminarProveedor(@Param("nit") Integer nit);
}
