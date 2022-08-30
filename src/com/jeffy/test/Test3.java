package com.jeffy.test;

public class Test3 {
    public static void main(String[] args) {
        String num1="321";
        String num2="123";
        String cheng = cheng(num1, num2);
        System.out.println(cheng);
    }

    private static String cheng(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int c11=0;
        int c22=0;
        for (int i = 0; i < c1.length; i++) {
            c11=c11*10+c1[i]-48;
        }
        for (int i = 0; i < c2.length; i++) {
            c22=c22*10+c2[i]-48;
        }
        int result = c11 * c22;
        StringBuilder sb=new StringBuilder();
        while (result!=0){
            int ge = result % 10;
            sb.append(ge);
            result = result / 10;
        }
        String toString = sb.reverse().toString();
        return toString;
    }

}
