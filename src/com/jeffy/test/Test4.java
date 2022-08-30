package com.jeffy.test;

public class Test4 {
    public static void main(String[] args) {
        String s="Hello World   ";
        int count=0;
        boolean flag=true;
        StringBuilder sb =new StringBuilder();
        for (int i = s.length()-1; i > 0; i--) {
            if(s.charAt(i)==' '&& flag){
                continue;
            }else if(s.charAt(i)==' ' && !flag){
                break;
            }
            flag=false;
            count++;
            sb.append(s.charAt(i));
        }
        StringBuilder result = sb.reverse();
        System.out.println("最后一个单词的长度为"+count+"的"+result);
    }
}
