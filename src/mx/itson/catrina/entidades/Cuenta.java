/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import mx.itson.catrina.enumeradores.Tipo;
import mx.itson.catrina.ui.Main;

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
     * 
     * @param mes
     * @param movimientosDesordenados
     * @return 
     */
    public List<Movimiento> obtenerListaMovimientos(int mes, List<Movimiento> movimientosDesordenados){
        List<Movimiento> movimientosOrdenados = new ArrayList<>();
        
        for(Movimiento movimiento : movimientosDesordenados) {
            if(movimiento.getFecha().getMonth() == mes) {
                movimientosOrdenados.add(movimiento);
            }
        }
        
        movimientosOrdenados.sort((mov1,mov2) -> mov1.getFecha().compareTo(mov2.getFecha()));
        return movimientosOrdenados;
    }
    
    /**
     * 
     * @param mes
     * @param listaMovimientos, mes
     * @return 
     */
    public double getSaldoInicial(int mes, List<Movimiento> listaMovimientos){
        double saldoInicial = 0;
        
        for(Movimiento movimiento : listaMovimientos){
            for(int i = 0; i < mes; i++){
                if(movimiento.getFecha().getMonth() == i && movimiento.getTipo() == Tipo.DEPOSITO){
                    saldoInicial += movimiento.getCantidad();
                } else if (movimiento.getFecha().getMonth() == i && movimiento.getTipo() == Tipo.RETIRO){
                    saldoInicial -= movimiento.getCantidad();
                }
            }
        }
        return saldoInicial;
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
