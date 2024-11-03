package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Orden;
import uniandes.edu.co.proyecto.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Orden>{
    @Query(value = "SELECT * FROM registros", nativeQuery = true)
    Collection<Registro> darRegistros();

    @Query(value = "COMMIT", nativeQuery = true)
    void confirmar();

    @Query(value = "ROLLBACK", nativeQuery = true)
    void anular();

    @Query(value = "SET AUTOCOMMIT OFF", nativeQuery = true)
    void sinAutoCommit();

    //*RFC 6 */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Query(value = "SELECT * FROM registros where fechaIngreso >= TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery = true)
    Collection<Registro> registrosMesSR();
    
    //*RFC 7 */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Query(value = "SELECT * FROM registros where fechaIngreso >= TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery = true)
    Collection<Registro> registrosMesRC();

    //*RF 10 */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO registros (orden, fechaIngreso, bodega) VALUES ( :orden , :fechaIngreso, :bodega)", nativeQuery = true)
    void insertarRegistro(@Param("orden") Long orden, @Param("fechaIngreso") Date fecha_ingreso,
    @Param("bodega") Long bodega);
}
