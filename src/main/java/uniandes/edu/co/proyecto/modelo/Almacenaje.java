package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="almacenajes")
public class Almacenaje {

    @EmbeddedId
    private AlmacenajePK pk;

    private Integer costo_promedio;

    private Integer capacidad;
    private Integer cantidad;

    private Integer nivel_minimo;

    public Almacenaje(){;}

    public Almacenaje(Integer costoPromedio, Integer capacidadBodega, Integer nivelMinimoReorden, Integer cantidad, Bodega bodega, Producto producto){
        this.pk=new AlmacenajePK(bodega, producto);
        this.costo_promedio = costoPromedio;
        this.capacidad = capacidadBodega;
        this.nivel_minimo = nivelMinimoReorden;
        this.cantidad=cantidad;
    }

    

    public Integer getCosto_promedio() {
        return costo_promedio;
    }

    public void setCosto_promedio(Integer costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getNivel_minimo() {
        return nivel_minimo;
    }

    public void setNivel_minimo(Integer nivel_minimo) {
        this.nivel_minimo = nivel_minimo;
    }

    public AlmacenajePK getPk() {
        return pk;
    }

    public void setPk(AlmacenajePK pk) {
        this.pk = pk;
    }

    
}
