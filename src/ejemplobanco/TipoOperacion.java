package practicabanco;

public class TipoOperacion {
    String descripcion;
    int idTipoOperacion;

    public TipoOperacion() {
       
    }

    public TipoOperacion(int idTipoOperacion) {
      this.idTipoOperacion=idTipoOperacion;
      switch (this.idTipoOperacion) {
      case 1:
           this.descripcion="Retiro";
           break;
      case 2:
           this.descripcion="Deposito";
           break;
      case 3:
           this.descripcion="Retiro por Cajero";
           break;
      default:
           this.descripcion="Otro";
           break;
      }
    
    }
    
     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(int idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    @Override
    public String toString() {
        return "TipoOperacion{" + "descripcion=" + descripcion + ", idTipoOperacion=" + idTipoOperacion + '}';
    }    
}
