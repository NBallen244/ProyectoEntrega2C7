package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Almacenaje;

public interface BodegaRepository extends JpaRepository<Bodega, Long>{
    @Query(value = "SELECT * FROM bodegas", nativeQuery = true)
    Collection<Bodega> darBodegas();

    /*RFC3 */
    @Query(value = "SELECT * FROM almacenajes WHERE almacenajes.bodega =:bodega", nativeQuery = true)
    Collection<Almacenaje> darInventario (@Param("bodega") Long bodega);

    @Query(value = "SELECT * FROM bodegas WHERE id = :id", nativeQuery = true)
    Bodega darBodega(@Param("id") Long id);



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE id = : id", nativeQuery = true)
    void eliminarBodega(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE sucursal = :sucursal", nativeQuery = true)
    void eliminarBodegaPorSucursal(@Param("sucursal") Long sucursal);


    @Modifying
    @Transactional
    @Query(value = "UPDATE bodegas SET nombre = :nombre, tamaño = :tamaño, sucursal = :sucursal WHERE id = :id", nativeQuery = true)
    void actualizarBodega(@Param("nombre") String nombre, @Param("tamaño") Long tamaño, @Param("sucursal") Long sucursal);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas (id, nombre, tamaño, sucursal) VALUES ( paso.nextval , :nombre, :tamaño, :sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamaño") Long tamaño, @Param("sucursal") Long sucursal);
}
