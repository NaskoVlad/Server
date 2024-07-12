package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start server!");
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
//                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
//
//                    final String name = in.readLine();
//                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

                    out.println("Приветствую вас в нашем ресторане!");// 1
                    out.println("За каким столиком вы хотели бы разместиться?");

                    String number = in.readLine();

                    out.println(String.format("Да конечно размещайтесь за столик %s", number)); // 2

                    out.println("Принести ли вам детское меню?"); // 3

                    String answer = in.readLine(); // 4
                    String result;
                    if(answer.equals("да")){
                        result = "Да конечно мы принесем вам детское меню";
                    } else if(answer.equals("нет")){
                        result = "Хорошо, принесем только обычное меню";
                    } else {
                        result = "Хорошо";
                    }
                    out.println(result); // 5

                    out.println("Принести ли вам сразу сок?"); // 6

                    String juice = in.readLine(); // 7
                    String result2;
                    if(juice.equals("да")){
                        result = "Да конечно мы принесем вам сок";
                    } else if(juice.equals("нет")){
                        result = "Хорошо, принесем все ваши блюда по готовности";
                    } else {
                        result = "Хорошо";
                    }


                }
            }
        }
    }
}