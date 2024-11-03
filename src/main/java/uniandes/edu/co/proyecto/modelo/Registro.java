package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="registros")
public class Registro {

    @Id
    @OneToOne
    @JoinColumn(name = "orden", referencedColumnName = "id")
    private Orden orden;

    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    private Bodega bodega;


    public Registro(){;}

    public Registro(Orden orden, Date fechaIngreso, Bodega bodega){
        this.fechaIngreso = fechaIngreso;
        this.orden = orden;
        this.bodega = bodega;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    

}