package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class RegistroPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "orden", referencedColumnName = "id")
    private Orden orden;

    public RegistroPK(){
        super();
    }

    public RegistroPK(Orden orden){
        super();
        this.orden = orden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden ordenDeCompra) {
        this.orden = ordenDeCompra;
    }

    
}
