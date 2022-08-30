package com.jeffy.test2;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(getSum(10));
    }

    private static int getSum(int i) {
        if(i==1){
            return 1;
        }
        return (getSum(i-1)+1)*2;
    }
}
