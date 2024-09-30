package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ofertas")
public class Oferta {

    @EmbeddedId
    private OfertaPK pk;

    public Oferta(){;}

    public Oferta(Proveedor nit_proveedor, Producto cod_barras_prod){

        this.pk = new OfertaPK(nit_proveedor, cod_barras_prod);

    }

    public OfertaPK getPk() {
        return pk;
    }

    public void setPk(OfertaPK pk) {
        this.pk = pk;
    }

    

}

