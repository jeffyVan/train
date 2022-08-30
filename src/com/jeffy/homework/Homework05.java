package com.jeffy.homework;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Homework05 {
    public static void main(String[] args) throws IOException {

    }

    @Test
    public void file1() throws IOException {
        File file = new File("e:\\mytemp");
        if (!file.exists()) {
            file.mkdirs();
        }
        File txt = new File(file, "hello.txt");
        if (txt.exists()) {
            System.out.println("已存在");
        } else {
            txt.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(txt));
        bw.write("hello world!!!");
        bw.close();
    }
    @Test
    public void file2() throws IOException {
        String file="E:\\mytemp\\hello.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        int num=1;String s="";
        while ((s=br.readLine())!=null){
            System.out.println(num+s);
            num++;
        }
        br.close();
    }

}
