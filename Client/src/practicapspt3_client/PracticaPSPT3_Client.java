package practicapspt3_client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class PracticaPSPT3_Client {

    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 6000);
        System.out.println("Conectando al servidor");
        int intentos = 1;
        int numero;
        Scanner sc = new Scanner(System.in);
        String respuesta = "";

        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
        System.out.println("Introduce el numero: ");
        numero = sc.nextInt();
        sc.nextLine();
        salida.writeInt(numero);

        while (intentos < 5) {
            respuesta = entrada.readUTF();
            if (respuesta.contains("acertado")) {
                //System.out.println(respuesta);
                break;
            } else {
                System.out.println("Introduce el numero: ");
                numero = sc.nextInt();
                sc.nextLine();
                salida.writeInt(numero);
            }
            intentos++;
        }
        System.out.println(respuesta);

            entrada.close();
            cliente.close();
            System.out.println("Conexion cerrada");
        }

    }
