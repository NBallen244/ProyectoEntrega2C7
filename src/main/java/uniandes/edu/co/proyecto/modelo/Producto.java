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
<<<<<<< HEAD
    //@GeneratedValue(strategy=GenerationType.AUTO) 
=======
    @GeneratedValue(strategy=GenerationType.AUTO) 
>>>>>>> 7c3745da8f668361933a86c301ade972431b2e48
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

<<<<<<< HEAD
    public Producto(Integer cod_barras, String nombre, Integer costoBodega, Integer precioUnitario, String presentacion, Integer cantidadPresentacion, String unidadMedida, String especifEmpacado, LocalDate fechaExpiracion){
        
        this.cod_barras = cod_barras;
=======
    public Producto(String nombre, Integer costoBodega, Integer precioUnitario, String presentacion, Integer peso, Integer volumen, String unidadMedida, Integer cantidadPresentacion,  Date fecha_vencimiento, Categoria categoria){
        
>>>>>>> 7c3745da8f668361933a86c301ade972431b2e48
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

<<<<<<< HEAD
    public Integer getCodigoBarras() {
        return cod_barras;
    }

    public void setCodigoBarras(Integer cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getNombre() {
=======
    //GETTERS

    public Integer getCodigoBarras(){
        return cod_barras;
    }

    public String getNombre(){
>>>>>>> 7c3745da8f668361933a86c301ade972431b2e48
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

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCostoBodega(Integer costo_bodega){
        this.costo_bodega = costo_bodega;
    }

    public void setPrecioUnitario(Integer precio_unitario){
        this.precio_unitario = precio_unitario;
    }

    public void setPresentacion(String presentacion){
        this.presentacion = presentacion;
    }

    public void setPeso(Integer peso){
        this.peso = peso;
    }

    public void setVolumen(Integer volumen){
        this.volumen = volumen;
    }

    public void setUnidadMedida(String unidad_medida){
        this.unidad_medida = unidad_medida;
    }

    public void setCantidadPresentacion(Integer cantidad_presentacion){
        this.cantidad_presentacion = cantidad_presentacion;
    }

    public void setFechaVencimiento(Date fecha_vencimiento){
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }


}
