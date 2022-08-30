package com.jeffy.qqserver;

import com.jeffy.qqcommon.Message;
import com.jeffy.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * 推送新闻
 */
public class SendNewToAllUserThread extends Thread{
    Scanner sc=new Scanner(System.in);

    @Override
    public void run() {
        while (true){
            System.out.println("请输入想推送的新闻：");
            String news = sc.nextLine();
            //封装新闻
            Message message = new Message();
            message.setContent(news);
            message.setSender("服务器");
            String time = new Date().toString();
            message.setSendTime(time);
            message.setMesType(MessageType.MESSAGE_CHAT_ALL);
            System.out.println(time+"服务器推送新闻： "+news);

            //获取在线所有线程
            String allId = ManageServerConnectClientThread.getAllId();
            String[] ids = allId.split(" ");
            for (int i = 0; i < ids.length; i++) {
                ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(ids[i]);
                Socket socket = thread.getSocket();
                //输出流
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
