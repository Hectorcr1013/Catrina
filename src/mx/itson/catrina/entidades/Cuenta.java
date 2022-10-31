/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;
import mx.itson.catrina.enumeradores.Tipo;

/**
 *
 * @author chiqu
 */
public class Cuenta {
    
    private String producto;
    private String cuenta;
    private String clabe;
    private String moneda;
    
    private List<Movimiento> movimientos;
    private Cliente cliente;
    private ResumenPeriodo resumenPeriodo;
    private Tipo tipo;
    
    
    
    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return the clabe
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * @param clabe the clabe to set
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }
    
    /**
     * @return the resumenPeriodo
     */
    public ResumenPeriodo getResumenPeriodo() {
        return resumenPeriodo;
    }

    /**
     * @param resumenPeriodo the resumenPeriodo to set
     */
    public void setResumenPeriodo(ResumenPeriodo resumenPeriodo) {
        this.resumenPeriodo = resumenPeriodo;
    }

    /**
     * 
     * @param json The parameter for deserializar method
     * @return the cuenta
     */
    public Cuenta deserializar(String json){
        Cuenta cuenta = new Cuenta();
        try{
            cuenta = new Gson().fromJson(json, Cuenta.class);
        } catch(Exception ex){
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return cuenta;
    }
    
    /**
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    
    
}
