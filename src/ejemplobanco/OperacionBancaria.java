/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobanco;

import java.util.Date;

/**
 *
 * @author Joaquín
 */
public class OperacionBancaria {
    String claveOperacion;
    Date fechaOperacion;
    long idOperacion;
    TipoOperacion tipo;
    int monto;

    public OperacionBancaria(String claveOperacion, long idOperacion, TipoOperacion tipo, int monto) {
        this.claveOperacion = claveOperacion;
        this.fechaOperacion = new Date();
        this.idOperacion = idOperacion;
        this.tipo = tipo;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "OperacionBancaria{" + "claveOperacion=" + claveOperacion + ", fechaOperacion=" + fechaOperacion + ", idOperacion=" + idOperacion + ", tipo=" + tipo + ", monto=" + monto + '}';
    }
    
    
    
    
}
