package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Registro;
import uniandes.edu.co.proyecto.modelo.RegistroPK;

public interface RegistroRepository extends JpaRepository<Registro, RegistroPK>{
    @Query(value = "SELECT * FROM registros", nativeQuery = true)
    Collection<Registro> darRegistros();

    @Query(value = "COMMIT", nativeQuery = true)
    void confirmar();

    @Query(value = "ROLLBACK", nativeQuery = true)
    void anular();

    @Query(value = "SET AUTOCOMMIT OFF", nativeQuery = true)
    void sinAutoCommit();

    public interface RespuestaConsultaMes{
        Timestamp getFecha();
        Long getOrden();
        Long getProveedor();
    }

    //*RFC 6 */
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = SQLException.class)
    @Query(value = "SELECT registros.fecha_ingreso fecha, ordenes.proveedor proveedor, registros.orden orden FROM registros inner join ordenes on ordenes.id = registros.orden where fecha_ingreso >= TO_DATE(:fecha, 'YYYY-MM-DD') AND bodega = :bodega", nativeQuery = true)
    Collection<RespuestaConsultaMes> registrosMesSR(@Param("fecha") String fecha, @Param("bodega") Long bodega);
    
    //*RFC 7 */
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
    @Query(value = "SELECT registros.fecha_ingreso fecha, ordenes.proveedor, registros.orden orden FROM registros inner join ordenes on ordenes.id = registros.orden where fecha_ingreso >= TO_DATE(:fecha, 'YYYY-MM-DD') AND bodega = :bodega", nativeQuery = true)
    Collection<RespuestaConsultaMes> registrosMesRC(@Param("fecha") String fecha, @Param("bodega") Long bodega);

    //*RF 10 */
    @Modifying
    @Query(value = "INSERT INTO registros (orden, fecha_ingreso, bodega) VALUES ( :orden , :fecha_ingreso, :bodega)", nativeQuery = true)
    void insertarRegistro(@Param("orden") Long orden, @Param("fecha_ingreso") Date fecha_ingreso,
    @Param("bodega") Long bodega);
}
