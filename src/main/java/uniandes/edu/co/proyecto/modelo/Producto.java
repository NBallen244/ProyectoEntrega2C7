package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO) 
    private String codigoDeBarras;

    private String nombre;

    private Integer costoBodega;

    private Integer precioUnitario;

    private String presentacion;

    private Integer cantidadPresentacion;

    private String unidadMedida;

    private String especifEmpacado;

    private LocalDate fechaExpiracion;

    public Producto(){;}

    public Producto(String codigoDeBarras, String nombre, Integer costoBodega, Integer precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadMedida, String especifEmpacado, LocalDate fechaExpiracion){
        
        this.codigoDeBarras = codigoDeBarras;
        this.nombre = nombre;
        this.costoBodega = costoBodega;
        this.precioUnitario = precioUnitario;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadMedida = unidadMedida;
        this.especifEmpacado = especifEmpacado;
        this.fechaExpiracion = fechaExpiracion; 

    }

    public String getCodigoBarras() {
        return codigoDeBarras;
    }

    public void setCodigoBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getCostoBodega() {
        return costoBodega;
    }

    public void setCostoBodega(Integer costoBodega){
        this.costoBodega = costoBodega;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario){
        this.precioUnitario = precioUnitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion){
        this.presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return costoBodega;
    }

    public void setCantidadPresentacon(Integer cantidadPresentacion){
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public String getUnidadMedia() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida){
        this.unidadMedida = unidadMedida;
    }

    public String getEspecifEmpacado() {
        return especifEmpacado;
    }

    public void setEspecifEmpacado(String especifEmpacado){
        this.especifEmpacado = especifEmpacado;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate feechaExpiracion){
        this.fechaExpiracion = fechaExpiracion;
    }

}
