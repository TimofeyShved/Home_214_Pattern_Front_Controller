package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Паттерн (фронт котроллер) - в данном примере мы передаём все запросы ему,
        // а он их обрабатывает и выдаёт результат

        try (Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNext()){
                String nextLine = scanner.nextLine();

                new Thread(){
                    @Override
                    public void run() {
                        new DispatcherService().process(nextLine);
                    }
                }.start();
            }
        }

    }
}


class DispatcherService{
    void process(String url){
        switch (url){
            case "home": new HomeController().show(); break;
            case "user": new UserController().show(); break;
            default: new ErrorController().show();
        }
    }
}

class HomeController{
    void show(){
        System.out.println("this is home");
    }
}

class UserController{
    void show(){
        System.out.println("this is User");
    }
}

class ErrorController{
    void show(){
        System.out.println("error");
    }
}