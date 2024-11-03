package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Almacenaje;
import uniandes.edu.co.proyecto.modelo.AlmacenajePK;

public interface AlmacenajeRepository extends JpaRepository<Almacenaje, AlmacenajePK>{
    @Query(value = "SELECT * FROM almacenajes", nativeQuery = true)
        Collection<Almacenaje> darAlmacenajes();

    
    @Query(value = "SELECT * FROM almacenajes WHERE bodega = :bodega AND producto = :producto", nativeQuery = true)
    Almacenaje darAlmacenaje(@Param("bodega") Long bodega, @Param("producto") Long producto);

    /*RFC3 */
    public interface RespuestaInventario{
        Long getProducto();
        Long getCapacidad();
        Long getCantidad();
        Long getN_minimo();
        Long getCosto();
    }
    
    @Query(value = "SELECT almacenajes.producto producto, almacenajes.capacidad capacidad, almacenajes.cantidad cantidad, almacenajes.costo_promedio costo, almacenajes.nivel_minimo n_minimo FROM almacenajes WHERE bodega = :bodega", nativeQuery = true)
    Collection<RespuestaInventario> darInventarioBodega(@Param("bodega") Long bodega);

    @Query(value = "SELECT * FROM almacenajes WHERE bodega = :bodega", nativeQuery = true)
    Collection<Almacenaje> darAlmacenajesPorBodega(@Param("bodega") Long bodega);

    @Query(value = "SELECT * FROM almacenajes WHERE producto = :producto", nativeQuery = true)
    Collection<Almacenaje> darAlmacenajesPorProducto(@Param("producto") Long producto);

    
    /*RFC1 */
    public interface RespuestaIndiceOcupacion{
        Long getBodega();
        Long getProducto();
        int getIndice_ocupacion();
    }

    @Query(value = "SELECT almacenajes.bodega bodega, almacenajes.producto producto, productos.volumen*almacenajes.cantidad/almacenajes.capacidad indice_ocupacion FROM almacenajes INNER JOIN productos ON almacenajes.producto = productos.cod_barras INNER JOIN bodegas on almacenajes.bodega = bodegas.id WHERE bodegas.sucursal = :sucursal", nativeQuery = true)
    Collection<RespuestaIndiceOcupacion> darIndiceOcupacion(@Param("sucursal") Long sucursal);




    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE bodega = :bodega AND producto = :producto", nativeQuery = true)
    void eliminarAlmacenaje(@Param("bodega") Long bodega, @Param("producto") Long producto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE bodega = :bodega", nativeQuery = true)
    void eliminarAlmacenajePorBodega(@Param("bodega") Long bodega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE producto = :producto", nativeQuery = true)
    void eliminarAlmacenajePorProducto(@Param("producto") Long producto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE almacenajes SET costo_promedio = :costo_promedio, capacidad = :capacidad, cantidad = :cantidad, nivel_minimo = :nivel_minimo WHERE bodega = :bodega AND producto = :producto", nativeQuery = true)
    void actualizarAlmacenaje(@Param("bodega") Long bodega, @Param("producto") Long producto, @Param("capacidad") Long capacidad,
                    @Param("cantidad") Long cantidad, @Param("costo_promedio") Long costo_promedio,
                    @Param("nivel_minimo") Long nivel_minimo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO almacenajes (bodega, producto, capacidad, cantidad, costo_promedio, nivel_minimo) VALUES ( :bodega, :producto, :capacidad, :cantidad, :costo_promedio, :nivel_minimo)", nativeQuery = true)
    void insertarAlmacenaje(@Param("bodega") Long bodega, @Param("producto") Long producto, @Param("capacidad") Long capacidad,
        @Param("cantidad") Long cantidad, @Param("costo_promedio") Long costo_promedio,
        @Param("nivel_minimo") Long nivel_minimo);
}
