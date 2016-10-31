package factorial.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class factorialCliente {

    public static void main(String[] args) {
        String ip = "192.168.9.120";
        int puerto = 1234;
        int numFact = 13;
        System.out.println(" socket " + ip + " " + puerto);
        
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;
        try {
            
            socketCliente = new Socket(ip, puerto);
            System.out.println("Enviando solicitud de conexion...");
             
            entrada = new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter( new OutputStreamWriter(socketCliente.getOutputStream()), true);
            
            salida.println(numFact);
            
            System.out.println("recibiendo ... " + entrada.readLine());
            
            socketCliente.close();
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }
}
    

