package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="registros")
public class Registro {

    @EmbeddedId
    private RegistroPK pk;

    private Date fecha_ingreso;

    @ManyToOne
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    private Bodega bodega;


    public Registro(){;}

    public Registro(Orden orden, Date fechaIngreso, Bodega bodega){
        this.fecha_ingreso = fechaIngreso;
        this.pk = new RegistroPK(orden);
        this.bodega = bodega;
    }

    public void setPK(Orden orden) {
        this.pk = new RegistroPK(orden);
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public RegistroPK getPK() {
        return this.pk;
    }

    public void setFecha_ingreso(Date fechaIngreso) {
        this.fecha_ingreso = fechaIngreso;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    

}