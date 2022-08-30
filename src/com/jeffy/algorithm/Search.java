package com.jeffy.algorithm;


import java.util.Scanner;

public class Search {

    private static int[] arr={1,4,16,24,28,36,57,62,73,89,94,107};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i = Integer.parseInt(s);
        int index = binarySearch(arr, i);
        System.out.println(index);


    }


    //二分查找
    public static int binarySearch(int[] arr,int search){
        int left=0;
        int right=arr.length-1;
        int mid=(left+right)/2;

        while (left<=right){
            if(arr[mid]==search){
                return mid;
            }
            if(arr[mid]<search){
                left=mid+1;
                mid=(left+right)/2;
            }
            if (arr[mid]>search){
                right=mid-1;
                mid=(left+right)/2;
            }
        }

        return -1;
    }
}
