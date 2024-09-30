package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Oferta;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Proveedor;


public interface OfertaRepository extends JpaRepository <Oferta, Integer>{

    @Query(value = "SELECT * FROM ofertas", nativeQuery=true )
    Collection<Oferta> darOfertas();

    @Query(value = "SELECT * FROM ofertas WHERE id= :id", nativeQuery=true)
    Oferta darOferta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ordenes (proveedor, producto) VALUES(proyecto_sequence.nextval, :proveedor, :producto)", nativeQuery = true)
    void insertarOferta(@Param("proveedor")Proveedor proveedor, @Param("producto")Producto producto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ofertas SET proveedor=:proveedor, producto=:producto WHERE id = :id", nativeQuery = true)
    void actualizarOferta(@Param("id") Long id, @Param("proveedor")Proveedor proveedor, @Param("producto")Producto producto);

    @Modifying
    @Transactional
    @Query(value = "DELET FROM ofertas WHERE id = :id", nativeQuery = true)
    void eliminarOferta(@Param("id") Long id);
}
