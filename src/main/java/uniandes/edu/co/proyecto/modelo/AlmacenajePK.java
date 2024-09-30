package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AlmacenajePK implements Serializable  {

    @ManyToOne
    @JoinColumn(name = "bodega", referencedColumnName = "id")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "cod_barras")
    private Producto producto;

    public AlmacenajePK() {
    }

    public AlmacenajePK(Bodega bodega, Producto producto) {
        super();
        this.bodega = bodega;
        this.producto = producto;
    }
    
}
