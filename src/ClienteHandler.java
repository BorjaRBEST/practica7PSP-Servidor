import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClienteHandler extends Thread {
    private Socket clienteSocket;

    public ClienteHandler(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run() {
        try {
            // Configuración de los flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            // Leer el número del cliente
            String numeroStr = entrada.readLine();
            int numero = Integer.parseInt(numeroStr);

            // Calcular el cuadrado y enviarlo de vuelta al cliente
            int cuadrado = numero * numero;
            salida.println("El cuadrado de " + numero + " es " + cuadrado);

            // Cerrar conexión con el cliente
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}