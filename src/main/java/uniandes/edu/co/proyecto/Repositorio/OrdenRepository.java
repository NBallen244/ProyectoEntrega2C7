package uniandes.edu.co.proyecto.repositorio;

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

    @Query(value = "SELECT * FROM ordenes WHERE id= :id", nativeQuery=true)
    Orden darOrden(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes (id, estado, fecha_estimada, proveedor, bodega_destino) VALUES(paso.nextval, 'vigente', :fecha_estimada, :proveedor, :bodega_destino)", nativeQuery = true)
    void insertarOrden(@Param("fecha_estimada")Date fecha_estimada, 
    @Param("proveedor")Long proveedor, @Param("bodega_destino")Long bodega_destino);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET estado=:'anulada', fecha_estimada=:fecha_estimada,fecha_llegada=:fecha_llegada,fecha_creacion=:fecha_creacion,proveedor=:proveedor,bodega_destino=:bodega_destino WHERE id = :id AND estado IS NOT 'entregada' ", nativeQuery = true)
    void actualizarOrdenAnulada(@Param("id") Long id, @Param("fecha_estimada")Date fecha_estimada, @Param("fecha_llegada")Date fecha_llegada, @Param("fecha_creacion")Date fecha_creacion, 
    @Param("proveedor")Long proveedor, @Param("bodega_destino")Long bodega_destino);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ordenes SET estado=:'entregada', fecha_estimada=:fecha_estimada,fecha_llegada=:fecha_llegada,fecha_creacion=:fecha_creacion,proveedor=:proveedor,bodega_destino=:bodega_destino WHERE id = :id AND estado IS NOT 'anulada' ", nativeQuery = true)
    void actualizarOrdenEntregada(@Param("id") Long id, @Param("fecha_estimada")Date fecha_estimada, @Param("fecha_llegada")Date fecha_llegada, @Param("fecha_creacion")Date fecha_creacion, 
    @Param("proveedor")Long proveedor, @Param("bodega_destino")Long bodega_destino);


    @Modifying
    @Transactional
    @Query(value = "DELET FROM ordenes WHERE id = :id", nativeQuery = true)
    void eliminarOrden(@Param("id") Long id);
}

