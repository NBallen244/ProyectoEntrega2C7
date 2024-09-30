package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OfertaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "nit")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "cod_barras")
    private Producto producto;

    public OfertaPK(){
        super();
    }

    public OfertaPK(Proveedor proveedor, Producto producto){
        super();
        this.proveedor = proveedor;
        this.producto = producto;
    }

    public Proveedor getProveedor(){
        return proveedor;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setNit_proveedor(Proveedor proveedor){
        this.proveedor =proveedor;
    }

    public void setCodigoBarras_producto(Producto producto){
        this.producto = producto;
    }
}
