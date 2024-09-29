package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Integer id;

    private String nombre;

    private Integer tamaño;

    private String direccion;

    private Integer telefono;

    public Sucursal(){;}

    public Sucursal(String nombre, Integer tamaño, String direccion, Integer telefono){

        this.nombre = nombre;
        this.tamaño = tamaño;
        this.direccion = direccion;
        this.telefono = telefono;

    }

    //TODO: GETTER Y SETTERS
}
