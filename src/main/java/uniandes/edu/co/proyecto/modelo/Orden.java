package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="ordenDeCompra")
public class Orden {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Integer id;

    private String estado;

    private LocalDate fechaEntrega;

    private LocalDate fechaLlegada;

    public Orden(){;}

    public Orden(String estado, LocalDate fechaEntrega, LocalDate fechaLlegada){
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.fechaLlegada = fechaLlegada;
    }

    //TODO: GETTERS Y SETTERS


}
