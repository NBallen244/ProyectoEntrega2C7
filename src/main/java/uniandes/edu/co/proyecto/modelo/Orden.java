package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Integer id;

    private String estado;

    private Date fecha_estimada;

    private Date fecha_llegada;

    private Date fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "nit")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "bodega_destino", referencedColumnName = "id")
    private Bodega bodega_destino;

    public Orden(){;}

    public Orden(String estado, Date fecha_estimada, Date fecha_llegada, Date fecha_creacion, Proveedor proveedor, Bodega bodega_destino){
        this.estado = estado;
        this.fecha_estimada = fecha_estimada;
        this.fecha_llegada = fecha_llegada;
        this.fecha_creacion = fecha_creacion;
        this.proveedor = proveedor;
        this.bodega_destino = bodega_destino;
        
    }

    //GETTERS

    public Integer getId() {
        return id;
    }

    public String getEstado(){
        return estado;
    }

    public Date getFechaEstimada(){
        return fecha_estimada;
    }

    public Date getFechaLlegada(){
        return fecha_llegada;
    }

    public Date getFechaCreacion(){
        return fecha_creacion;
    }

    public Proveedor getProveedor(){
        return proveedor;
    }

    public Bodega getBodegaDestino(){
        return bodega_destino;
    }

    //SETTERS

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public void setFechaEstimada(Date fecha_estimada){
        this.fecha_estimada = fecha_estimada;
    }

    public void setFechaLlegada(Date fecha_llegada){
        this.fecha_llegada = fecha_llegada;
    }

    public void setFechaCreacion(Date fecha_creacion){
        this.fecha_creacion = fecha_creacion;
    }

    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    public void setBodegaDestino(Bodega bodega_destino){
        this.bodega_destino = bodega_destino;
    }

}
