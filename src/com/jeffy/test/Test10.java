package com.jeffy.test;

public class Test10 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            if(i == 5){
                zi zi = new zi();
                zi.start();
                zi.join();
            }
            System.out.println("hi");
            Thread.sleep(1000);
        }


    }
}

class zi extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}