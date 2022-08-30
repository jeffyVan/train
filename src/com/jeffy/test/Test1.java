package com.jeffy.test;

import java.util.Random;
import java.util.Scanner;

/**
 * 键盘输入数据并打乱
 */
public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        Random r = new Random();
        for (int i = 0; i < chars.length; i++) {
            int j = r.nextInt(chars.length);
            char temp = chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
        }
       /* for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }*/
        System.out.println(new String(chars));
    }
}
