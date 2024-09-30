package uniandes.edu.co.proyecto.repositorio;

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
    Almacenaje darAlmacenaje(@Param("bodega") Integer bodega, @Param("producto") Integer producto);

    @Query(value = "SELECT * FROM almacenajes WHERE bodega = :bodega", nativeQuery = true)
    Collection<Almacenaje> darAlmacenajesPorBodega(@Param("bodega") Integer bodega);

    @Query(value = "SELECT * FROM almacenajes WHERE producto = :producto", nativeQuery = true)
    Collection<Almacenaje> darAlmacenajesPorProducto(@Param("producto") Integer producto);



    @Query(value = "SELECT almacenajes.bodega, productos.volumen*almacenajes.cantidad/almacenajes.capacidad FROM almacenajes INNER JOIN productos ON almacenajes.producto = productos.cod_barras WHERE bodega = :bodega", nativeQuery = true)
    Collection<Almacenaje> darIndiceOcupacion(@Param("bodega") Integer bodega);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE bodega = :bodega AND producto = :producto", nativeQuery = true)
    void eliminarAlmacenaje(@Param("bodega") Integer bodega, @Param("producto") Integer producto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE bodega = :bodega", nativeQuery = true)
    void eliminarAlmacenajePorBodega(@Param("bodega") Integer bodega);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM almacenajes WHERE producto = :producto", nativeQuery = true)
    void eliminarAlmacenajePorProducto(@Param("producto") Integer producto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE almacenajes SET costo_promedio = :costo_promedio, capacidad = :capacidad, cantidad = :cantidad, nivel_minimo = :nivel_minimo WHERE bodega = :bodega AND producto = :producto", nativeQuery = true)
    void actualizarAlmacenaje(@Param("bodega") Integer bodega, @Param("producto") Integer producto, @Param("capacidad") Integer capacidad,
                    @Param("cantidad") Integer cantidad, @Param("costo_promedio") Integer costo_promedio,
                    @Param("nivel_minimo") Integer nivel_minimo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO almacenajes (bodega, producto, capacidad, cantidad, costo_promedio, nivel_minimo) VALUES ( :bodega, :producto, :capacidad, :cantidad, :costo_promedio, :nivel_minimo)", nativeQuery = true)
    void insertarAlmacenaje(@Param("bodega") Integer bodega, @Param("producto") Integer producto, @Param("capacidad") Integer capacidad,
        @Param("cantidad") Integer cantidad, @Param("costo_promedio") Integer costo_promedio,
        @Param("nivel_minimo") Integer nivel_minimo);
}
