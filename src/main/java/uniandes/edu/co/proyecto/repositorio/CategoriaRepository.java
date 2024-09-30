package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    @Query(value = "SELECT * FROM categorias", nativeQuery = true)
    Collection<Categoria> darCategorias();

    
    @Query(value = "SELECT * FROM categorias WHERE codigo = :codigo", nativeQuery = true)
    Categoria darCategoria(@Param("codigo") Long codigo);

    @Query(value = "SELECT * FROM categorias WHERE nombre = :nombre", nativeQuery = true)
    Collection<Categoria> darCategoriasPorNombre(@Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categorias WHERE codigo = : codigo", nativeQuery = true)
    void eliminarCategoria(@Param("codigo") Long codigo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE categorias SET nombre = :nombre, descripcion = :descripcion, caracteristicas = :caracteristicas WHERE codigo = :codigo", nativeQuery = true)
    void actualizarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categorias (codigo, nombre, descripcion, caracteristicas) VALUES ( paso.nextval , :nombre, :descripcion, :caracteristicas)", nativeQuery = true)
    void insertarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicas") String caracteristicas);
}