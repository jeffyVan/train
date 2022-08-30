package com.jeffy.qqclient;

import com.jeffy.qqcommon.Message;
import com.jeffy.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;

//一个socket一个线程管理
public class ClientConnectServerThread extends Thread {

    private Socket socket;

    @Override
    public void run() {
        while (true){
            try {
                //线程中循环获取服务器消息
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                String mesType = message.getMesType();
                if(mesType.equals(MessageType.MESSAGE_RET_ONLINE_LIST)){
                    //返回消息，用户列表
                    String content = message.getContent();//获取消息内容
                    String[] split = content.split(" ");
                    System.out.println("在线用户列表如下：");
                    for (String s : split) {
                        System.out.println("用户"+s);
                    }
                }else if(mesType.equals(MessageType.MESSAGE_COM_MES)){
                    //私聊消息
                    String sender = message.getSender();
                    String getter = message.getGetter();
                    String text = message.getContent();
                    String sendTime = message.getSendTime();

                    System.out.println(sendTime+sender+"对"+getter+" 说: "+text);
                }else if(mesType.equals(MessageType.MESSAGE_CHAT_ALL)){
                    //群发消息
                    String sender = message.getSender();
                    String text = message.getContent();
                    String sendTime = message.getSendTime();

                    System.out.println(sendTime+sender+"对大家说: "+text);
                }else if(mesType.equals(MessageType.MESSAGE_FILE)){
                    //发送文件
                    String text = message.getContent();
                    String[] files = text.split(" ");
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files[0]));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(files[1]));
                    byte[] bytes = bis.readAllBytes();
                    bos.write(bytes);
                    bos.close();
                    bis.close();
                    String sendTime = message.getSendTime();
                    String sender = message.getSender();
                    String getter = message.getGetter();

                    System.out.println(sendTime+sender+"向"+getter+"发送文件 ");
                }else {
                    System.out.println("其他操作");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ClientConnectServerThread() {
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
