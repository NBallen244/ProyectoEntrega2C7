package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;

public class ProductosOrden {
    @EmbeddedId
    private ProductosOrdenPK pk;

    private Long cantidad;
    private Long precio_acordado;
    
    public ProductosOrdenPK getPk() {
        return pk;
    }
    public void setPk(ProductosOrdenPK pk) {
        this.pk = pk;
    }
    public Long getCantidad() {
        return cantidad;
    }
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    public Long getPrecio_acordado() {
        return precio_acordado;
    }
    public void setPrecio_acordado(Long precio_acordado) {
        this.precio_acordado = precio_acordado;
    }


}
