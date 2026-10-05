package org.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient {

    public static void main(String[] args) {
            String serverAddress = "127.0.0.1";
            int port = 123;
            String message = "Привет, сервер";

            try(Socket socket = new Socket(serverAddress, port)){
                System.out.println("Подключение к серверу");

                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                output.println(message);
                System.out.println("Серверу отправлено сообщение " + message);

                String response = input.readLine();
                System.out.println("Получен ответ сервера " + response);



            } catch (IOException e) {
                System.err.println("Ошибка клиента: " + e.getMessage());
            }
            }

    }

