package com.jeffy.test;

public class AtoB {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "deabc";

        boolean flag = canBeB(a, b);
        if (flag) {
            System.out.println("A能变成B");
        }else {
            System.out.println("nonono!");
        }

//        StringBuilder sb = new StringBuilder();
    }

    public static boolean canBeB(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String first = String.valueOf(a.charAt(0));
            String other = a.substring(1);
            a = other + first;
            if (a.equals(b)) {
                return true;
            }
        }
        return false;
    }


}
