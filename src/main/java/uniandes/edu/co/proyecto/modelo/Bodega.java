package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bodegas")
public class Bodega {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Long id;

    private String nombre;

    private Long tamaño;

    @ManyToOne
    @JoinColumn(name = "sucursal", referencedColumnName = "id")
    private Sucursal sucursal;

    public Bodega(){;}

    public Bodega(String nombre, Long tamaño, Sucursal sucursal){

        this.tamaño = tamaño;
        this.nombre = nombre;
        this.sucursal=sucursal;

    }

    public Long getId() {
        return id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Long getTamaño(){
        return tamaño;
    }

    public void setTamaño(Long tamaño){
        this.tamaño = tamaño;
    }

}
