package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="registros")
public class Registro {

    @EmbeddedId
    private RegistroPK registroPK;

    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "nit")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "sucursal", referencedColumnName = "id")
    private Sucursal sucursal;

    public Registro(){;}

    public Registro(Orden ordenDeCompra, Sucursal sucursal, Date fechaIngreso, Bodega bodega, Proveedor proveedor){
        this.sucursal = sucursal;
        this.fechaIngreso = fechaIngreso;
        this.registroPK = new RegistroPK(ordenDeCompra);
        this.bodega = bodega;
        this.proveedor = proveedor;
    }

    public RegistroPK getRegistroPK() {
        return registroPK;
    }

    public void setRegistroPK(RegistroPK registroPK) {
        this.registroPK = registroPK;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }    

    
}
