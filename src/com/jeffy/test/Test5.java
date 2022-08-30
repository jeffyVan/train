package com.jeffy.test;

public class Test5 {
    public static void main(String[] args) {
//        统计水仙花数
        System.out.println(sxhs3());

        System.out.println(sxhs4());
    }

    private static int sxhs4() {
        int count=0;
        for (int i = 1000; i < 10000; i++) {
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100%10;
            int qian=i/1000;

            if(Math.pow(ge,4)+Math.pow(shi,4)+Math.pow(bai,4)+Math.pow(qian,4)==i){
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    private static int sxhs3() {
        /**/
        int count=0;
        for (int i = 100; i < 1000; i++) {
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100%10;
            if(Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3)==i){
                count++;
                System.out.println(i);
            }
        }
        return count;
    }
}
