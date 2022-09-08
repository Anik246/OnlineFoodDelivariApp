package com.example.onlinefood;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("[Server] Waiting for clients");
        ServerSocket serverSocket = new ServerSocket(6000);

        int count = 0;
        while (true) {

                Socket socket = serverSocket.accept();
                count++;
                System.out.println("Client no-" + count + " connected");
                new ClientHandler(socket);

            }
            }
        }


