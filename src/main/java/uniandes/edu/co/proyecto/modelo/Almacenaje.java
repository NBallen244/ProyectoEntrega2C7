package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="almacenaje")
public class Almacenaje {

    private Integer costoPromedio;

    private Integer capacidadBodega;

    private Integer nivelMinimoReorden;

    public Almacenaje(){;}

    public Almacenaje(Integer costoPromedio, Integer capacidadBodega, Integer nivelMinimoReorden){
        this.costoPromedio = costoPromedio;
        this.capacidadBodega = capacidadBodega;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

}
