/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// nombre del paquete
package Cliente;

// libreria de clases a usar
import java.net.*;
import java.io.*;
/**
 *
 * @author JuHU
 */
public class UDPCliente {

    // fucnion de entrada al programa principal
    public static void main(String args[]) {
        // Los argumentos dan el contenido del mensaje y dirección Servidor
        DatagramSocket unSocket = null;
        try {
            // se construye la conexion.
            unSocket = new DatagramSocket();
            // se almacena el parametro 1 del programa en bytes en lugar de string
            byte [] m = args[0].getBytes();
            // se obtiene el nombre o direccion a la cual se va a conectar del segundo parametro del programa
            InetAddress dirServ = InetAddress.getByName(args[1]);
            // se establece el puerto de la conexion a 7001
            int puertoServ = 7001;
            // se construlle el datagrama
            DatagramPacket peticion = new DatagramPacket(m, args[0].length(), dirServ, puertoServ);
            // se envia la peticion
            unSocket.send(peticion);
            // se inicializa un nuevo byte para la respuesta
            byte[] buffer = new byte[1000];
            // se construye un nuevo datagrama para la respuesta
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            // se recibe la respuesta
            unSocket.receive(respuesta);
             // se muestra en pantalla la respuesta
            System.out.println("Le devuelvo en este ejercicio de sockets: " + new String(respuesta.getData()));
        }catch (SocketException e){ // se capturan errores de socket o conexion.
            System.out.println("Socket: " + e.getMessage());
        }catch (IOException e){ // se caputaran errores de entrada y salida
            System.out.println("IO: " + e.getMessage());
        }finally { // al finalizar con o sin error se cierra la conexion.
            if(unSocket != null)
                unSocket.close();
        }
    }
}

