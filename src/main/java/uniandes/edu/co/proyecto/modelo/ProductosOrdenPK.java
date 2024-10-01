package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductosOrdenPK {
    @ManyToOne
    @JoinColumn(name = "orden", referencedColumnName = "id")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "cod_barras")
    private Producto producto;

    public ProductosOrdenPK(){
        super();
    }

    public ProductosOrdenPK(Orden orden, Producto producto){
        super();
        this.orden = orden;
        this.producto = producto;
    }
}
