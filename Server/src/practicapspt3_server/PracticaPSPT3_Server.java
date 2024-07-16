package practicapspt3_server;

import java.io.*;
import java.net.*;

public class PracticaPSPT3_Server {

    public static void main(String[] args) throws IOException {

        int numPuerto = 6000;
        int numeroAzar = (int) (Math.random() * 11);
        int intentos = 0;

        ServerSocket servidor = new ServerSocket(numPuerto);
        System.out.println("Esperando conexiones");

        Socket clienteSocket = servidor.accept();
        DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());;
        DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
        int numEntrada;
        System.out.println("El numero es: " + numeroAzar);
        while (intentos < 5) {
            numEntrada = entrada.readInt();
            if (numEntrada==numeroAzar) {
                System.out.println("Has acertado el numero");
                salida.writeUTF("Has acertado el numero y el numero de intentos:" + (intentos+1));
                break;
            }else{
                System.out.println("Has fallado");
                salida.writeUTF("Has fallado");
                
            }
            intentos++;
        }
        
        salida.close();
        clienteSocket.close();
        servidor.close();
        System.out.println("La conexion ha finalizado");
    }

}
