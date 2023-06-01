package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(org.example.ServerSocket.PORT)) {
            System.out.println("Сервер производит запуск: \n" + "Loading…  ██████████ 100%\n"
                    + "Сервер запущен.");

            CityGame cityGame = new CityGame();

            while (true) {
                String city;

                try (Socket clientSocket = server.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    final String name = in.readLine();
                    System.out.println("Поключился новый пользователь: " + name);
                    out.println(String.format("Привет %s, твой порт %d", name, clientSocket.getPort()));

                    boolean i = cityGame.isEmpty();
                    if (i == true){
                        out.println("Вы первый игрок, введите город.");
                        city = in.readLine();
                        cityGame.addCity(city);
                        out.println("Результат принят");
                    } else {
                        String s = cityGame.TheLastCity();
                        out.println("Последний названый город: " + s);
                        city = in.readLine();
                        if (cityGame.CitiesThatAreNotTrue(city) == true){
                            cityGame.addCity(city);
                            out.println("Результат принят");
                        } else {
                            System.out.println("Введен некортектный город.");
                            out.println("Такой город уже был назван или начат не с той буквы.");
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Не могу запустить сервер");
            throw new RuntimeException(e);
        }

    }
}