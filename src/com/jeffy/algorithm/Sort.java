package com.jeffy.algorithm;

import java.util.Arrays;

public class Sort {


        public static int[] arr = {20, 39, 7, 19, 53, 48, 76, 13, 44};
//    public static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//    public static int[] arr = {6, 3, 2, 7, 9, 5, 4, 8, 1};

    public static void main(String[] args) {
//        bubble(arr);//冒泡
//        choice(arr);//选择
//        insert(arr);//插入
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void bubble(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {//交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void choice(int[] arr) {
        int temp;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(arr));
    }

    private static void insert(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort2(int[] arr, int i, int j) {
        int left = i;
        int right = j;
        int temp = arr[i];

        if (left>=right){
            return;
        }

        while (left<right){
            while (arr[right]>temp && left<right){
                right--;
            }
            if(arr[right]<temp){
                arr[left]=arr[right];
            }
            while (arr[left]<temp && left<right){
                left++;
            }
            if(arr[left]>temp){
                arr[right]=arr[left];
            }
        }
        arr[left]=temp;

        if(left-1>i ){
            quickSort2(arr,i,left-1);
        }
        if (j>left+1){
            quickSort2(arr,left+1,j);
        }


    }


    private static void quickSort(int[] arr, int left, int right) {

        int start = left + 1;
        int end = right;

        if (start > end) {
            return;
        }

        int basic = arr[left];

        while (start != end) {
            while (true) {
                if (arr[end] < basic || end <= start) {
                    break;
                }
                end--;
            }
            while (true) {
                if (arr[start] > basic || end <= start) {
                    break;
                }
                start++;
            }

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

        }
        int temp = arr[left];
        arr[left] = arr[start];
        arr[start] = temp;

        quickSort(arr, left, start - 1);
        quickSort(arr, start + 1, right);

    }


}
