/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// nombre del paquete
package Servidor;
// librerias a usar
import java.net.*;
import java.io.*;
/**
 *
 * @author JuHU
 */
public class UDPServidor {

    // entrada a la funcion principal
    public static void main(String args[]){

        DatagramSocket unSocket = null;
        try{
            // se construye un nuevo socket en el puerto 7001
            unSocket = new DatagramSocket(7001);
            // crea un socket en el puerto acordado
            // tamaño maximo de paquete a recibir 20
            byte[] buffer = new byte[20];
            while(true){ // siempre escuchamos
                // creamos el datagrama para la peticion.
                DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
                // nos quedamos esperando la peticion.
                unSocket.receive(peticion);
                // traducimos la respuesta, datos, direccion, etc.
                DatagramPacket respuesta = new DatagramPacket(peticion.getData(),
                        peticion.getLength(),
                        peticion.getAddress(),
                        peticion.getPort());
                // y le enviamos la respuesta
                unSocket.send(respuesta);
            }
        }
        catch (SocketException e){ // capturamos errores de conexion.
            System.out.println("Socket: " + e.getMessage());
        }catch (IOException e) { // erroers de entrada y salida
            System.out.println("IO: " + e.getMessage());
        }finally { // cerramos la conexion.
            if(unSocket != null)
                unSocket.close();
        }
    }
}
