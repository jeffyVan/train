package com.jeffy.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String s = bufferedReader.readLine();
        System.out.println(s);


//        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        byte[] bytes = bis.readAllBytes();
//        String s = new String(bytes);
//        System.out.println(s);
//        socket.shutdownInput();

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client");
        bufferedWriter.newLine();
        bufferedWriter.flush();


//        outputStream.write("hello client".getBytes());
//        socket.shutdownOutput();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
