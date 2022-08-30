package com.jeffy.homework;

public class Homework04 {
    public static void main(String[] args) {
        User user = new User();
        new Thread(user).start();
        new Thread(user).start();
    }
}

class User implements Runnable {

    private int money = 10000;

    @Override
    public void run() {
        synchronized (this) {
            while (money >= 1000) {
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000元，剩余：" + money);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("余额不足");
        }

    }

}