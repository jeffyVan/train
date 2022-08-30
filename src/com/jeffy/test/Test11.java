package com.jeffy.test;


import java.io.*;

public class Test11 {
    public static void main(String[] args) {
        String srcFile = "D:\\b.jpeg";
        String distFile = "E:\\b.jpeg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(distFile));
            byte[] bytes = bis.readAllBytes();
            bos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      /*  FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(distFile);
            byte[] bytes=new byte[1024];
            int temp;
            while ((temp=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/


    }
}
