package RMIFormas;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
public class ServListarFormas extends UnicastRemoteObject implements IListaForma{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private Vector laLista;
    private int version;
    
    public ServListarFormas()throws RemoteException{
        laLista = new Vector();
        version = 0;
    }

    public IForma nuevaForma(ObjGrafico g) throws RemoteException{

        version++;
       	IForma s = new ServFormas( g, version);
       	System.out.println("SE ACABA DE AGREGAR UN OBJETO GRAFICO CON VERSION: " + s.obtVersion());
       	laLista.addElement(s);
        return s;
     }

    public  Vector todaForma()throws RemoteException{
        
        return laLista;
    }

    public int obtVersion() throws RemoteException{
        return version;
    } 
	public static void main(String args[]){
         	if(System.getSecurityManager()==null)
			System.setSecurityManager(new RMISecurityManager());
        	System.out.println("Programa principal LISTO");
        	String nombre="//127.0.0.1:1100/listaDeFormas";	
			try{
            			IListaForma listaFormas = new ServListarFormas();
            			System.out.println("Luego de crear objeto servidor");
				Naming.rebind(nombre, listaFormas); 
            			System.out.println("Servidor de listado de formas O.K.");
        		}catch(Exception e) {
            			System.out.println("Error servidor:" + e.getMessage());
        }
    }
}