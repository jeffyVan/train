package com.jeffy.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;

        while (sum <= 200) {
            System.out.println("请输入一个整数：");
            String nextLine = sc.nextLine();
            int i = Integer.parseInt(nextLine);
            arrayList.add(i);
            sum += i;
        }


        for (int j = 0; j < arrayList.size(); j++) {
            System.out.println(arrayList.get(j));
        }

    }
}
