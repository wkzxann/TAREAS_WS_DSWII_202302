package com.example.demo.tarea;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int PORT = 13;

    public Server() {

        try {
        	Socket clientSocket;
        	
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
            	System.out.println("<------------- 1 Iniciando ServerSocket ------------->");
				System.out.println("<------------- 2 A la espera de  clientSocket ------------->");
                clientSocket = serverSocket.accept();
                System.out.println("<------------- 3 Llegada de un clientSocket ------------->");

                File fileOrigen = new File("C:/server/Java-Aquino.jpeg");
                FileInputStream fis = new FileInputStream(fileOrigen);
                DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());

                int bytesLeidos;
                while ((bytesLeidos = fis.read()) != -1) {
                	salida.write(bytesLeidos);
                }

                fis.close();
                salida.close();
                
                System.out.println("<------------- 4 Finalizando Comunicación ------------->");
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}