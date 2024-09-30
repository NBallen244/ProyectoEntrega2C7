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

    public Integer getNIT() {
        return NIT;
    }

    public void setNIT(Integer NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

}
