package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {

    @Id
    private Integer NIT;

    private String nombre;

    private String direccion;

    private String contacto;

    private Integer telefono;

    public Proveedor(){;}

    public Proveedor(Integer NIT, String nombre, String direccion, String contacto, Integer telefono){
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    //TODO: GETTERS Y SETTERS
}
