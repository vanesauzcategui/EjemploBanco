/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobanco;

/**
 *
 * @author Noheli@ V@ness@ Orteg@ Alvarez
 */
public class TipoCuenta {
    String nombreCuenta;
    String descripcion;
    long idTipoCuenta;

    public TipoCuenta(String nombreCuenta, String descripcion, long idTipoCuenta) {
        this.nombreCuenta = nombreCuenta;
        this.descripcion = descripcion;
        this.idTipoCuenta = idTipoCuenta;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(long idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    @Override
    public String toString() {
        return "TipoCuenta{" + "nombreCuenta=" + nombreCuenta + ", descripcion=" + descripcion + ", idTipoCuenta=" + idTipoCuenta + '}';
    }
    
    
    
}
