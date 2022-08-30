package com.jeffy.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework03 {
    public static void main(String[] args) {

        AA a = new AA();
        BB b = new BB();
        new Thread(a).start();
        new Thread(b).start();
    }
}


class AA implements Runnable {

    private static boolean loop = true;

    @Override
    public void run() {

        while (loop) {
            int i = (new Random().nextInt(100)) + 1;
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setLoop(boolean loop) {
        AA.loop = loop;
    }
}

class BB implements Runnable {

    @Override
    public void run() {
        while (true) {
            String s = new Scanner(System.in).nextLine();
            if (s.equalsIgnoreCase("Q")) {
                AA.setLoop(false);
                break;
            }
        }
    }
}