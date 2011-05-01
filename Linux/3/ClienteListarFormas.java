package RMIFormas;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
import java.awt.Rectangle;
import java.awt.Color;


public class ClienteListarFormas{

    public static void main(String args[]){

        String opcion = "Leer";
        String tipoForma = "No especificada";
        if(args.length > 0)  opcion = args[0];	// Leer o Dibujar
        if(args.length > 1)  tipoForma = args[1];// especifica figura plana, l�nea
        System.out.println("Opcion = " + opcion + " Forma = " + tipoForma);
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new RMISecurityManager());
        } else {
            System.out.println("Ya tiene un gestor de seguridad, se puede enviar mensaje RMI");
        }
        IListaForma unaListaFormas = null;
        String nombre1="//localhost:1100/listaDeFormas";
        try{
                unaListaFormas  = (IListaForma) Naming.lookup(nombre1);
                System.out.println("Servidor hallado");
                Vector sLista = unaListaFormas.todaForma();
                System.out.println("Hay vector con formas");
                if(opcion.equals("Leer")){
                        for(int i=0; i<sLista.size(); i++){
                            ObjGrafico g = ((IForma)sLista.elementAt(i)).obtEstados();
                            g.print();
                        }
                } else {
                    ObjGrafico g = new ObjGrafico(tipoForma, new Rectangle(40,40,300,400),Color.red,
                                            Color.blue, true);
                    System.out.println("Figura creada");
                    unaListaFormas.nuevaForma(g);
                    System.out.println("Forma almacenada");
                }
        }catch(RemoteException e) {
            System.out.println("Todas las formas: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Lookup: " + e.getMessage());
        }
    }
}
