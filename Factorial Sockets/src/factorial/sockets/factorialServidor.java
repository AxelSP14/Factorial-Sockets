/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alumno
 */
public class factorialServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = null;
        PrintWriter salida = null;

        Socket socket = null;
        
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Esperando conexion de cliente en el puerto 1234...");
        
        while (true) {
            try {
                socket = serverSocket.accept();
                
                System.out.println("Conexion establecida desde la IP: " + socket.getInetAddress());
                
                entrada = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                salida = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()), true);
               
                int fact = Integer.parseInt(entrada.readLine());
               
                int result = fact;
                for(int i=1; i<fact; i++){
                    result = result * i;
                }    
                salida.println(result);
                socket.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
    

