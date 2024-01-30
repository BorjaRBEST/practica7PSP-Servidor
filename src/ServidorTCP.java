import java.io.*;
import java.net.*;

public class ServidorTCP {
    public static void main(String[] args) {
        final int puerto = 12345; // Puerto en el que escuchará el servidor
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor esperando conexiones en el puerto " + puerto + "...");

            while (true) {
                Socket cliente = servidor.accept(); // Espera a que un cliente se conecte
                System.out.println("Cliente conectado desde " + cliente.getInetAddress().getHostAddress());

                // Crea un nuevo hilo para manejar la comunicación con el cliente
                Thread clienteThread = new ClienteHandler(cliente);
                clienteThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}