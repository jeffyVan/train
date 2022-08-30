package com.jeffy.test;

import java.util.Random;

/**
 * 5字，4个字母（大小写），1个数字（任意位置）
 */
public class Test2 {
    public static void main(String[] args) {

        char[] zimu = new char[52];
        for (int i = 0; i < zimu.length; i++) {
            if (i < 26) {
                zimu[i] = (char) ('a' + i);
            } else {
                zimu[i] = (char) ('A' + i - 26);
            }
        }


        Random r = new Random();
        String s = "";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(zimu.length);
            s += zimu[index];
        }
//        System.out.println(s);


        int shuzi = r.nextInt(10);

        int in = r.nextInt(s.length() + 1);
        String result="";
        if (in < 4 && in >0) {
            String start = s.substring(0, in);
            String end = s.substring(in);
            result=start+shuzi+end;
        }else if(in == 4) {
            result=s+shuzi;
        }else {
            result=shuzi+s;
        }

        System.out.println(result);
    }
}
