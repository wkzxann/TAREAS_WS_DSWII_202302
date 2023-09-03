package com.example.demo.tarea;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private final int PORT = 13;
    private final String IP = "localhost";

    public Client() {
        try {
            Socket clientSocket = new Socket(IP, PORT);
            System.out.println("<------------- 1 Iniciando Comunicación ------------->");
            System.out.println("Inet Address : " + clientSocket.getInetAddress());

            File fileDestino = new File("C:/cliente/Java-Aquino-2.jpeg");
            FileOutputStream fos = new FileOutputStream(fileDestino);
            DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());

            int bytesLeidos;
            while ((bytesLeidos = entrada.read()) != -1) {
                fos.write(bytesLeidos);
            }

            fos.close();
            
            System.out.println("<------------- 2 Archivo recibido correctamente ------------->");
            clientSocket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}