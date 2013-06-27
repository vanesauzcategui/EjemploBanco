/*
 * //autor Diana Estupiñan
 */
package ejemplobanco;

public class Cliente {
    long idCliente;
    String nombreCliente;

    public Cliente() {
    }
    
    public Cliente(String nombreCliente,long idCliente) {
        this.idCliente=idCliente;
        this.nombreCliente=nombreCliente;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + '}';
    }
    
    
    
    
}
