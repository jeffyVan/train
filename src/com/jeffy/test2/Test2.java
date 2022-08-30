package com.jeffy.test2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(osw);
        bufferedWriter.write("hello server");
        bufferedWriter.newLine();
        bufferedWriter.flush();


//        outputStream.write("hello server".getBytes());
//        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


//        byte[] bytes = inputStream.readAllBytes();
//        String s = new String(bytes);
//        System.out.println(s);
//        socket.shutdownInput();

        bufferedReader.close();
        bufferedWriter.close();
        osw.close();
        socket.close();
    }
}
