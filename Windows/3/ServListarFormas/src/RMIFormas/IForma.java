package RMIFormas;

import java.rmi.*;
import java.util.Vector;

public interface IForma extends Remote {
   int obtVersion() throws RemoteException;
   ObjGrafico obtEstados() throws RemoteException;
}
