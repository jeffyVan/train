package com.jeffy.test2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        byte[] bytes = line.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);
        socket.close();
    }

    //接收端
    @Test
    public void A() throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        String s = new String(data, 0, packet.getLength());
        if("4".equals(s)){
            System.out.println("1234");
        }else {
            System.out.println("5678");
        }
        socket.close();
    }

    //发送端
    @Test
    public void B() throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        byte[] bytes = line.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);
        socket.close();
    }
    @Test
    public void m1(){
        System.out.println(new Scanner(System.in).next());
    }

}
