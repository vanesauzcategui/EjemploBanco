/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplobanco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Noheli@ V@ness@ Orteg@ Alvarez
 */
public class EjemploBanco{

     static ArrayList<Cliente> clientes = new ArrayList<>();
     static ArrayList<TipoCuenta> cuentas=new ArrayList<>();
     static TipoOperacion[] operaciones= null;
     static ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<>();
     
     
   
    public static void main(String[] args) throws IOException {
         InputStreamReader leer_entrada= new InputStreamReader(System.in);
         BufferedReader entrada=new BufferedReader(leer_entrada); 
         int opcion;
         do{
         System.out.println("Ingrese numero de lo que desea realizar\n 1.Insertar clientes\n 2. Crear tipos de cuentas\n 3.Crear tipos de operaciones\n 4.Abrir cuenta Bancaria\n 5.Registrar Operaciones bancarias\n 6.Generar repoortes\n 7.Salir");
            opcion=Integer.parseInt(entrada.readLine());
          
           switch (opcion) {
                case 1:
                    insertarClientes(entrada);
                    break;
                 case 2:
                     crearTiposCuentas(entrada);
                     break;
                 case 3:
                    crearTiposOperaciones(entrada);
                    break; 
                 case 4:
                     abrirCuentaBancaria(entrada);
                     break;
                 case 5:
                    registrarOperacionBancaria(entrada);
                     break;
                 case 6:
                    generarReportes(entrada);
                    break; 
                default:
                    break;
                }
           }while(opcion!=7);

    }
    
    public static void insertarClientes( BufferedReader entrada) throws IOException{
        int numCliente;
        System.out.println("Ingrese cantidad de Clientes que va a insertar");
        numCliente=Integer.parseInt(entrada.readLine());
        while(numCliente>0){
             System.out.println("Digite el id del cliente a crear");
             long id=Long.parseLong(entrada.readLine());
             System.out.println("Digite el nombre del cliente a crear");
             String nombre=entrada.readLine();
             Cliente cc=new Cliente(nombre,id);
             clientes.add(cc);
             numCliente--;
             System.out.println("EL CLENTE SE HA REGISTRADO EXITOSAMENTE"); 
             System.out.println(cc.toString());
        }
    }
    
    public static void  crearTiposCuentas(BufferedReader entrada) throws IOException{
         System.out.println("Ingrese cantidad de tipos de cuentas a crear");
         int cant=Integer.parseInt(entrada.readLine());
         while(cant>0){
            System.out.println("Digite el id del tipo de cuenta");
            long id=Long.parseLong(entrada.readLine());
                for(TipoCuenta tc:cuentas){
                    if(id==tc.idTipoCuenta){System.out.println("ESTE TIPO DE CUENTA YA ESTA REGISTRADA EN EL SISTEMA");cant=0;}
                }
            System.out.println("Ingrese nombre de tipo de cuenta a crear");
            String nombre=entrada.readLine();
            System.out.println("Ingrese descripcion de tipo de cuenta a crear");
            String descripcion=entrada.readLine();
            TipoCuenta tc=new TipoCuenta(nombre,descripcion,id);
            cuentas.add(tc);
            cant--;
            System.out.println("EL TIPO DE CUENTA SE HA REGISTRADO EXITOSAMENTE"); 
            System.out.println(tc.toString()); 
        }
    }
    
     public static void  crearTiposOperaciones(BufferedReader entrada) throws IOException{
            System.out.println("Ingrese cantidad de tipos de operaciones bancarias a crear");
            int cant=Integer.parseInt(entrada.readLine());
            operaciones=new TipoOperacion[cant];
            while(cant>0){
            System.out.println("Ingrese digito de opciones validas para los tipo de operaciones que va a crear:\n 1.Retiro\n 2.deposito\n 3.Retiro x Caja");
            int id=Integer.parseInt(entrada.readLine());
            TipoOperacion to=new TipoOperacion(id); 
            operaciones[--cant]=to;
            System.out.println("EL TIPO DE OPERACION SE HA REGISTRADO EXITOSAMENTE");
            System.out.println(to.toString());
            }
         
     }
     
      public static void   abrirCuentaBancaria(BufferedReader entrada) throws IOException{
              System.out.println("Ingrese id del cliente que va abrir la cuenta");
              long idCliente=Long.parseLong(entrada.readLine());
              Cliente cliente=buscarCliente(idCliente,entrada);
              TipoCuenta tc=buscarTipoCuenta(entrada);
              System.out.println("Ingrese numero de la cuenta bancaria a crear");
              String numeroCuenta=entrada.readLine();
              System.out.println("Ingrese saldo de apertura de la cuenta bancaria");
              long saldoCuenta=Long.parseLong(entrada.readLine());
              long idCuenta=cuentasBancarias.size();
              CuentaBancaria cb=new CuentaBancaria(idCuenta,numeroCuenta, saldoCuenta, cliente,tc);
               System.out.println("LA APERTURA DE LA CUENTA FUE EXITOSA");
              System.out.println(cb.toString());
              cuentasBancarias.add(cb);
      }
      
      public static Cliente buscarCliente(long id, BufferedReader entrada) throws IOException{
              for(Cliente t:clientes){
                  if(t.idCliente==id)
                      System.out.println("Cliente se asocio a la cuenta bancaria");
                      return t;
               }
             System.out.println("registre en el sistema al cliente: Ingrese nombre");
             String nombre=entrada.readLine();
             System.out.println("Ingrese id del cliente");
             long idCliente=Long.parseLong(entrada.readLine());
             Cliente c=new Cliente(nombre,idCliente);
             clientes.add(c);
             return(c);
      }
      
      public static void registrarOperacionBancaria(BufferedReader entrada) throws IOException{
              
              System.out.println("Digite numero de Cuenta bancaria");
              String numeroCuenta=entrada.readLine();
              boolean aux=false;
              for(CuentaBancaria t:cuentasBancarias){
                  if(t.numeroCuenta.equals(numeroCuenta)){
                        if(operaciones==null){
                             System.out.println("ERROR LOS TIPOS DE OPERACIONES NO HAN SIDO CREADAS");
                             crearTiposOperaciones(entrada);
                        }
                        System.out.println("Seleccione tipo de operacion a realizar Nota");
                        TipoOperacion tipoOperacion=buscarTipoOperacion(entrada);
                        System.out.println("Ingrese monto de la Operacion");
                        long monto=Long.parseLong(entrada.readLine());
                        if(tipoOperacion.idTipoOperacion==1||tipoOperacion.idTipoOperacion==3){
                                 if(monto>t.saldoCuenta){
                                    System.out.println("ERROR MONDO EXCEDE EL SALDO DE LA CUENTA");
                                    return;
                                 }else{
                                      t.saldoCuenta-=monto;
                                  }
                        }
                        t.saldoCuenta+=monto;
                        System.out.println("Ingrese clave de la Operacion");
                        String clave=entrada.readLine();
                        long idOperacion=(long)t.operaciones.size();
                        int montof=(int)monto;
                        OperacionBancaria operacionB=new OperacionBancaria(clave,idOperacion, tipoOperacion, montof);
                        t.operaciones.add(operacionB); 
                        aux=true;
                   }
               }
              if(!aux)System.out.println("NUEMRO DE CUENTA BANCARIA NO EXISTE");
      }
      
     
      public static TipoOperacion buscarTipoOperacion(BufferedReader entrada) throws IOException{
             TipoOperacion tipo=null;
          do{
              for(TipoOperacion t:operaciones){
                    System.out.println(t.toString());
               }
               System.out.println("Seleccione Tipo de Operacion");
               int idTipoOperacion=Integer.parseInt(entrada.readLine());
               for(TipoOperacion t:operaciones){
                    if(t.idTipoOperacion==idTipoOperacion)
                        tipo=t;
               }
            } while(tipo==null);
               return tipo;
               
      }
      
       public static TipoCuenta buscarTipoCuenta(BufferedReader entrada) throws IOException{
             TipoCuenta tipo=null;
            do{
                int tam=cuentas.size();
               if(tam==0){ System.out.println("Tipos de cuentas no han sido creadas");crearTiposCuentas(entrada);}
               for(TipoCuenta t:cuentas){
                    System.out.println(t.toString());
               }
               System.out.println("Seleccione Tipo de Cuenta Digitando idTipoCuenta");
               long idTipoCuenta=Long.parseLong(entrada.readLine());
                for(TipoCuenta t:cuentas){
                    if(t.idTipoCuenta==idTipoCuenta)
                        tipo=t;
               }
            } while(tipo==null);
               return tipo;
               
      }
      
      
      public static void generarReportes(BufferedReader entrada) throws IOException{
           System.out.println("Ingrese numero del reporte que desea generar \n 1.Consultar Usuarios y Observar sus cuentas \n 2.Consultar cuenta Bancaria\n 3.Listado de Usuarios\n 4.Listado de cuentas por tipo\n 5.Listado de tipos de operaciones\n 6.Listado de tipo de cuenta");
           int opcion=Integer.parseInt(entrada.readLine());
           switch (opcion) {
                case 1:
                    consultarUsuarios();
                    break;
                 case 2:
                    consultarCuenta(entrada);
                    break; 
                 case 3:
                    listarUsuarios();
                    break; 
                 case 4:
                    listarCuentasxTipos();
                    break;
                 case 5:
                   listarTipoOperaciones();
                    break; 
                 case 6:
                   listarTipoCuentas();
                    break; 
                default:
                    break;
                }
      }
      
      static void consultarUsuarios(){
           for(Cliente c:clientes){
                 System.out.println(c.toString());
                 for(CuentaBancaria cuenta:cuentasBancarias){
                     if(c.idCliente==cuenta.cliente.idCliente) System.out.println(cuenta.toString());
                 }
           }
      }
      
      static void consultarCuenta(BufferedReader entrada) throws IOException{
              System.out.println("Ingrese numero de Cuenta");
              String numeroCuenta=entrada.readLine();
              for(CuentaBancaria t:cuentasBancarias){
                  if(t.numeroCuenta.equals(numeroCuenta)){
                     for(OperacionBancaria op:t.operaciones){
                           System.out.println(op.toString());
                     }
                     System.out.println("El saldo total de la cuenta es:"+t.saldoCuenta);
                  }
              }
      }
      
      static void listarUsuarios(){
           for(Cliente c:clientes){
                  System.out.println(c.toString());
            }
      }
      
      static void listarCuentasxTipos(){
           for(TipoCuenta tc:cuentas){
               System.out.println(tc.toString());
                 for(CuentaBancaria cb:cuentasBancarias){
                     if(tc.idTipoCuenta==cb.tipoCuenta.idTipoCuenta){
                          System.out.println(cb.toString());
                     }
                 }
               
            }
      }
      
      static void listarTipoOperaciones(){
          for(TipoOperacion to:operaciones){
               System.out.println(to.toString());
          }
      }
      
      static void listarTipoCuentas(){
          for(TipoCuenta tc:cuentas){
               System.out.println(tc.toString());
          }
      }
   
}
