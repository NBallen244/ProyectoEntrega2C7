package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RegistroPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ordenes", referencedColumnName = "id")
    private Orden ordenDeCompra;

    public RegistroPK(){
        super();
    }

    public RegistroPK(Orden ordenDeCompra){
        super();
        this.ordenDeCompra = ordenDeCompra;
    }

    public Orden getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(Orden ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    
}
