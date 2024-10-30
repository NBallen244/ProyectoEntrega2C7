package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Producto;


public interface ProductoRepository extends JpaRepository <Producto, Long>{

    @Query(value = "SELECT * FROM productos", nativeQuery=true )
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE cod_barras= :cod_barras", nativeQuery=true)
    Producto darProducto(@Param("cod_barras") int cod_barras);

    @Query(value = "SELECT * FROM productos WHERE nombre= :nombre", nativeQuery=true)
    Collection<Producto> darProductoPorNombre(@Param("nombre") String nombre);

    /*RFC2.1 Precio en rango*/
    @Query(value = "SELECT productos.* FROM productos WHERE precio_unitario BETWEEN :menor AND :mayor", nativeQuery=true)
    Collection<Producto> darProductoRangoPrecios(@Param("menor") int menor, @Param("mayor") int mayor);

    /*RFC2.2 Vencimiento posterior a*/
    @Query(value = "SELECT productos.* FROM productos WHERE fecha_vencimiento > TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery=true)
    Collection<Producto> darProductoPosterior(@Param("fecha") String fecha);

    /*RFC2.3 Vencimiento anterior a*/
    @Query(value = "SELECT productos.* FROM productos WHERE fecha_vencimiento < TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery=true)
    Collection<Producto> darProductoAnterior(@Param("fecha") String fecha);

    /*RFC2.4 Disponible en x sucursal*/
    @Query(value = "SELECT productos.* FROM productos INNER JOIN almacenajes ON productos.cod_barras=almacenajes.producto INNER JOIN bodegas ON bodegas.id=almacenajes.bodega WHERE bodegas.sucursal = :sucursal", nativeQuery=true)
    Collection<Producto> darProductoSucursal(@Param("sucursal") Long sucursal);

    /*RFC2.5 Categoria*/
    @Query(value = "SELECT productos.* FROM productos INNER JOIN categorias ON productos.categoria=categorias.codigo WHERE categorias.codigo = :categoria", nativeQuery=true)
    Collection<Producto> darProductoCategoria(@Param("categoria") Long categoria);

    /*RFC5 */

    public interface RespuestaInsuficiente{
        Long getId();
        String getNombre();
        Long getBodega();
        Long getProveedor();
        Long getSucursal();
        int getCantidad();
    }
    @Query(value = "SELECT productos.cod_barras id, productos.nombre nombre, almacenajes.bodega bodega, ofertas.proveedor proveedor, bodegas.sucursal sucursal, almacenajes.cantidad cantidad FROM productos INNER JOIN almacenajes ON productos.cod_barras=almacenajes.producto INNER JOIN bodegas ON bodegas.id = almacenajes.bodega INNER JOIN ofertas ON productos.cod_barras=ofertas.producto WHERE almacenajes.cantidad<almacenajes.nivel_minimo", nativeQuery=true)
    Collection<RespuestaInsuficiente> darProductoInsuficiente();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, peso,  volumen, unidad_medida, cantidad_presentacion,  fecha_vencimiento, categoria) VALUES(paso.nextval, :nombre, :costo_bodega, :precio_unitario, :presentacion, :peso,  :volumen, :unidad_medida, :cantidad_presentacion,  :fecha_vencimiento, :categoria)",  nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo_bodega") Long costo_bodega, @Param("precio_unitario") Long precio_unitario, 
    @Param("presentacion") String presentacion, @Param("peso") Long peso, @Param("volumen") Long volumen, @Param("unidad_medida") String unidad_medida, 
    @Param("cantidad_presentacion") Long cantidad_presentacion, @Param("fecha_vencimiento") Date fecha_vencimiento, @Param("categoria") Long categoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre=:nombre, costo_bodega=:costo_bodega, precio_unitario=:precio_unitario, presentacion=:presentacion, peso=:peso,  volumen=:volumen, unidad_medida=:unidad_medida, cantidad_presentacion=:cantidad_presentacion,  fecha_vencimiento=:fecha_vencimiento, categoria=:categoria WHERE cod_barras = :cod_barras", nativeQuery = true)
    void actualizarProducto(@Param("cod_barras") Long cod_barras, @Param("nombre") String nombre, @Param("costo_bodega") Long costo_bodega, @Param("precio_unitario") Long precio_unitario, 
    @Param("presentacion") String presentacion, @Param("peso") Long peso, @Param("volumen") Long volumen, @Param("unidad_medida") String unidad_medida, 
    @Param("cantidad_presentacion") Long cantidad_presentacion, @Param("fecha_vencimiento") Date fecha_vencimiento, @Param("categoria") Long categoria);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE cod_barras = :cod_barras", nativeQuery = true)
    void eliminarProducto(@Param("cod_barras") Long cod_barras);
}
