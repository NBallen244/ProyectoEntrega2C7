package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    private String nombre;

    private Long tamaño;

    private String direccion;

    private Long telefono;

    @ManyToOne
    @JoinColumn(name = "ciudad", referencedColumnName = "id")
    private  Ciudad ciudad;

    public Sucursal(){;}

    public Sucursal(String nombre, Long tamaño, String direccion, Long telefono, Ciudad ciudad){
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    //TODO: GETTER Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTamaño() {
        return tamaño;
    }

    public void setTamaño(Long tamaño) {
        this.tamaño = tamaño;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
