package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private Integer cod_barras;

    private String nombre;

    private Integer costo_bodega;

    private Integer precio_unitario;

    private String presentacion;

    private Integer cantidad_presentacion;

    private String unidad_medida;

    private Integer peso;

    private Integer volumen;

    private Date fecha_vencimiento;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "codigo")
    private Categoria categoria;

    public Producto(){;}

    //repo y controller

    public Producto(String nombre, Integer costoBodega, Integer precioUnitario, String presentacion, Integer peso, Integer volumen, String unidadMedida, Integer cantidadPresentacion,  Date fecha_vencimiento, Categoria categoria){
        
        this.nombre = nombre;
        this.costo_bodega = costoBodega;
        this.precio_unitario = precioUnitario;
        this.presentacion = presentacion;
        this.peso = peso;
        this.volumen = volumen;
        this.unidad_medida = unidadMedida;
        this.cantidad_presentacion = cantidadPresentacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.categoria = categoria;

    }

    //GETTERS

    public Integer getCodigoBarras(){
        return cod_barras;
    }

    public String getNombre(){
        return nombre;
    }

    public Integer getCostoBodega(){
        return costo_bodega;
    }

    public Integer getPrecioUnitario(){
        return precio_unitario;
    }

    public String getPresentacion(){
        return presentacion;
    }

    public Integer getPeso(){
        return peso;
    }

    public Integer getVolumen(){
        return volumen;
    }

    public String getUnidadMedida(){
        return unidad_medida;
    }

    public Integer getCantidadPresentacion(){
        return cantidad_presentacion;
    }

    public Date getFechaVencimiento(){
        return fecha_vencimiento;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    //SETTERS

    public void setCodigoBarras(Integer cod_barras){
        this.cod_barras = cod_barras;
    }

    
}
