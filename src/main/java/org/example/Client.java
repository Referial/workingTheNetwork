package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static org.example.ServerSocket.HOST;
import static org.example.ServerSocket.PORT;

public class Client {

    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Введите имя пользователя:");

            writer.println(scanner.nextLine());

            System.out.println(reader.readLine());
            System.out.println(reader.readLine());

            writer.println(scanner.nextLine());

            System.out.println(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
