/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// nombre del paquete
package Cliente;
// librerias a usar
import java.net.*;
import java.io.*;
/**
 *
 * @author JuHU
 */
public class TCPCliente {

    // entrada al procedimiento pricniapal
    public static void main (String args[]) {
        Socket s = null;
        try{
            // puerto a usar
            int puertoServicio = 7800;
            // iniciamos el socket hacia el servidor en el parametro 2
            s = new Socket(args[1], puertoServicio);
            // construimos las entradas
            DataInputStream entrada = new DataInputStream( s.getInputStream());
            DataOutputStream salida =new DataOutputStream( s.getOutputStream());
            // escribimos lo que recibimos en el parametro 1
            salida.writeUTF(args[0]);
            // leemos la respuesta
            String datos = entrada.readUTF();
            // mostramos la respuesta en el servidor
            System.out.println("El servidor hace eco de: "+ datos);
        }catch (UnknownHostException e) { // error en la resolucion de nombre del servidor
            System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e) { // error en la lectura del mensaje
            System.out.println("EOF:"+e.getMessage());
        }catch (IOException e) { // error en la entrada del mensaje
            System.out.println("Linea leida:"+e.getMessage());
        } finally {
            if(s!=null) { // cerramos la conexion.
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("cerrar:"+e.getMessage());
                }
            }
        }
    }
}

