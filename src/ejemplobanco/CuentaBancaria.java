/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobanco;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joaquín
 */
public class CuentaBancaria {
    Date fechaApertura;
    long idCuentaBancaria;
    String numeroCuenta;
    long saldoCuenta;
    ArrayList <OperacionBancaria> operaciones;
    Cliente cliente;
    TipoCuenta tipoCuenta;

    public CuentaBancaria( long idCuentaBancaria, String numeroCuenta, long saldoCuenta, Cliente cliente,TipoCuenta tp) {
        this.fechaApertura = new Date();
        this.idCuentaBancaria = idCuentaBancaria;
        this.numeroCuenta = numeroCuenta;
        this.saldoCuenta = saldoCuenta;
        this.operaciones=null;
        this.cliente=cliente;
        this.tipoCuenta=tp;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public long getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(long idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ArrayList<OperacionBancaria> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(ArrayList<OperacionBancaria> operaciones) {
        this.operaciones = operaciones;
    }

    public long getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(long saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
    
    @Override
    public String toString() {
        return "CuentaBancaria{" + "fechaApertura=" + fechaApertura + ", idCuentaBancaria=" + idCuentaBancaria + ", numeroCuenta=" + numeroCuenta + ", saldoCuenta=" + saldoCuenta + ", operaciones=" + operaciones + ", cliente=" + cliente + ", tipoCuenta=" + tipoCuenta + '}';
    }

    private static class TipoCuenta {

        public TipoCuenta() {
        }
    }
}
