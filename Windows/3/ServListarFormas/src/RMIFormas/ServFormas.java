package RMIFormas;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ServFormas extends UnicastRemoteObject implements IForma {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6556116297077511253L;
	int miVersion;
    ObjGrafico f;
     
    public ServFormas(ObjGrafico g, int version)throws RemoteException{
    	f = g;
 		miVersion = version;
    }
    
    
	public int obtVersion() throws RemoteException {
	    return miVersion;
	}
	
   public ObjGrafico obtEstados() throws RemoteException{
        return f;
   }
}
