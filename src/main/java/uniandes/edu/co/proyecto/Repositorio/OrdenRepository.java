package uniandes.edu.co.proyecto.Repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long>{

    @Query(value = "SELECT * FROM ordenes", nativeQuery=true )
    Collection<Orden> darOrdenes();

    @Query(value = "select * from ordenes where id in (select max(id) from ordenes)", nativeQuery=true )
    Orden darUltimaOrden();

    @Query(value = "SELECT * FROM ordenes WHERE sucursal_destino = :sucursal_destino AND estado = 'vigente'", nativeQuery=true )
    Collection<Orden> darOrdenesXsucursalVigentes(@Param("sucursal_destino") Long sucursal);

    @Query(value = "SELECT * FROM ordenes WHERE id= :id", nativeQuery=true)
    Orden darOrden(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes (id, estado, fecha_creacion, fecha_estimada, proveedor, sucursal_destino) VALUES(paso.nextval, 'vigente', :fecha_creacion, :fecha_estimada, :proveedor, :sucursal_destino)", nativeQuery = true)
    void insertarOrden(@Param("fecha_creacion")Date fecha_creacion, @Param("fecha_estimada")Date fecha_estimada, 
    @Param("proveedor")Long proveedor, @Param("sucursal_destino")Long sucursal_destino);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET estado = 'anulada' WHERE id = :id AND estado = 'vigente' ", nativeQuery = true)
    void actualizarOrdenAnulada(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET estado = 'entregada' WHERE id = :id AND estado = 'vigente' ", nativeQuery = true)
    void actualizarOrdenEntregada(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ordenes WHERE id = :id", nativeQuery = true)
    void eliminarOrden(@Param("id") Long id);
}

