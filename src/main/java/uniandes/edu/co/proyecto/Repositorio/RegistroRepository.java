package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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

    //*RFC 6 */
    
    @Query(value = "SELECT * FROM registros where fecha_ingreso >= TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery = true)
    Collection<Registro> registrosMesSR(@Param("fecha") String fecha);
    
    //*RFC 7 */
    
    @Query(value = "SELECT * FROM registros where fecha_ingreso >= TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery = true)
    Collection<Registro> registrosMesRC(@Param("fecha") String fecha);

    //*RF 10 */
    @Modifying
    @Query(value = "INSERT INTO registros (orden, fecha_ingreso, bodega) VALUES ( :orden , :fecha_ingreso, :bodega)", nativeQuery = true)
    void insertarRegistro(@Param("orden") Long orden, @Param("fecha_ingreso") Date fecha_ingreso,
    @Param("bodega") Long bodega);
}
