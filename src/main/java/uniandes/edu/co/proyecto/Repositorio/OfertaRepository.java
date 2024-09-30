package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Oferta;
import uniandes.edu.co.proyecto.modelo.OfertaPK;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Proveedor;


public interface OfertaRepository extends JpaRepository <Oferta, OfertaPK>{

    @Query(value = "SELECT * FROM ofertas", nativeQuery=true )
    Collection<Oferta> darOfertas();

    @Query(value = "SELECT * FROM ofertas WHERE id= :id", nativeQuery=true)
    Oferta darOferta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ofertas (proveedor, producto) VALUES( :proveedor, :producto)", nativeQuery = true)
    void insertarOferta(@Param("proveedor")Integer proveedor, @Param("producto")Integer producto);


    @Modifying
    @Transactional
    @Query(value = "DELET FROM ofertas WHERE proveedor = :proveedor AND producto = :producto", nativeQuery = true)
    void eliminarOferta(@Param("proveedor") Proveedor proveedor, @Param("producto") Producto producto);
}
