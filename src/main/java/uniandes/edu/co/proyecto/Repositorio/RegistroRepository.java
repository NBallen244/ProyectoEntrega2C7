package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Registro;
import uniandes.edu.co.proyecto.modelo.RegistroPK;

public interface RegistroRepository extends JpaRepository<Registro, RegistroPK>{
    @Query(value = "SELECT * FROM registros", nativeQuery = true)
        Collection<Registro> darRegistros();

   @Modifying
    @Transactional
    @Query(value = "INSERT INTO registros (id_orden, fecha_ingreso, sucursal, bodega, proveedor) VALUES ( :id_orden , :fecha_ingreso, :sucursal, :bodega, :proveedor)", nativeQuery = true)
    void insertarRegistro(@Param("id_orden") Long id_orden, @Param("fecha_ingreso") Date fecha_ingreso, @Param("proveedor") Long proveedor,
    @Param("bodega") Long bodega, @Param("sucursal") Long sucursal);
}
