/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// nombre del paquete
package Servidor;
// librerias
import java.net.*;
import java.io.*;
/**
 *
 * @author JuHU
 */
public class TCPServidor {

    // punto de entrada en el procedimiento principal
    public static void main (String args[]) {
        try{
            // numero del puerto donde escuchamos
            int puertoServ = 7800;
            // empezamos a escuchar
            ServerSocket escuchaSocket = new ServerSocket(puertoServ);
            while(true) { // escuchamos indefinidamente
                Socket clienteSocket = escuchaSocket.accept(); // aceptamos conexiones
                Conexion c = new Conexion(clienteSocket); // hacemos que un hilo procese las conexiones
            }
        } catch(IOException e) {
            // error de entrada y salida
            System.out.println("Socket a la escucha o servidor:"+e.getMessage());}
        }
    }
    class Conexion extends Thread {

        DataInputStream entrada;
        DataOutputStream salida;
        Socket clienteSocket;

        public Conexion (Socket aClienteSocket) {
            try {
                clienteSocket = aClienteSocket;
                // establecemos la conexion
                entrada = new DataInputStream( clienteSocket.getInputStream());
                // establecemos la repuesta
                salida =new DataOutputStream( clienteSocket.getOutputStream());
                // iniciamos el hilo
                this.start();
            } catch(IOException e) {
                // errore de entrada y salida
                System.out.println("Conexion:"+e.getMessage());
            }
        }
    @Override
        public void run(){
            try {
                // leemos la entrada en formato UTF
                String datos = entrada.readUTF();
                // le respondemos lo mismo en formato UTF
                salida.writeUTF(datos);
            }catch (EOFException e){ // error en el tamaño del mensaje
                System.out.println("EOF:"+e.getMessage());
            } catch(IOException e) { // error de entrada y salida
                System.out.println("Linea leida:"+e.getMessage());
            } finally{ 
                try { // cerramos el socket
                    clienteSocket.close();
                }catch (IOException e){
                    /*Si falla el cierre del socket*/
                }
            }
        }
}
