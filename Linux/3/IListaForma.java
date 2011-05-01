package RMIFormas;
import java.rmi.*;
import java.util.Vector;

public interface IListaForma extends Remote {
  	IForma nuevaForma(ObjGrafico g) throws RemoteException;  	    
    Vector todaForma()throws RemoteException;
    int obtVersion() throws RemoteException;
}