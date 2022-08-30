package com.jeffy.test2;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test3 {
    public static void main(String[] args) {

    }

    /**
     * 服务端
     */
    @Test
    public void m1() throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        String score="src\\b.jpeg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = bufferedInputStream.readAllBytes();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(score));
        bufferedOutputStream.write(bytes);
        socket.shutdownInput();


        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("收到图片");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
    /**
     * 客户端
     */
    @Test
    public void m2() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();

        String pic="D:\\b.jpeg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(pic));
        byte[] bytes = bufferedInputStream.readAllBytes();
        outputStream.write(bytes);
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());


        bufferedReader.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();
    }
}
