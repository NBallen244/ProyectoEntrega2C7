package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedor {

    @Id
    private Long nit;

    private String nombre;

    private String direccion;

    private String contacto;

    private Long telefono;

    public Proveedor(){;}

    public Proveedor(Long nit, String nombre, String direccion, String contacto, Long telefono){
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    //TODO: GETTERS Y SETTERS

    public Long getNIT() {
        return nit;
    }

    public void setNIT(Long nit) {
        this.nit = nit;
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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

}
