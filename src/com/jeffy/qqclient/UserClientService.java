package com.jeffy.qqclient;

import com.jeffy.qqcommon.Message;
import com.jeffy.qqcommon.MessageType;
import com.jeffy.qqcommon.User;
import com.jeffy.qqserver.ManageServerConnectClientThread;
import com.jeffy.qqserver.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class UserClientService {

    private User u = new User();
    private Socket socket;

    /**
     * 检查登录用户是否合法
     * @param userId
     * @param pwd
     * @return
     */
    public boolean checkUser(String userId, String pwd) {
        boolean returnMark=false;

        u.setUserId(userId);
        u.setPassword(pwd);

        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);

            //发送object对象User
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            //读取对象Message
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            //判断消息类型
            if(message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                returnMark=true;//返回真
                //登录成功就创建一个线程
                ClientConnectServerThread thread = new ClientConnectServerThread(socket);
                thread.start();
                //线程加入到线程管理的hashmap中
                ManageClientConnectServerThread.addClientConnectServerThread(userId,thread);


            }else {
                //登录失败

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnMark;

    }

    /**
     * 获取用户在线列表
     */
    public void getOnlineList(){

        //建立消息对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_LIST);
        message.setSender(u.getUserId());

        //获取socket
        ClientConnectServerThread thread = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
        Socket socket = thread.getSocket();
        try {
            //对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 退出系统
     */
    public void exit(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 私聊
     */
    public void chatToUser(String who,String text){
        //设置消息
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COM_MES);
        message.setContent(text);
        message.setSender(u.getUserId());
        message.setGetter(who);
        String time = new Date().toString();
        message.setSendTime(time);
        System.out.println(time+u.getUserId()+"对"+who+" 说: "+text);
        //输出
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 群发
     */
    public void chatToAll(String sender, String text){
        //群发消息
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CHAT_ALL);
        message.setContent(text);
        message.setSender(sender);
        String time = new Date().toString();
        message.setSendTime(time);
        System.out.println(time+sender+"对大家说: "+text);
        //输出流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件
     */
    public void sendFile(String sender,String getter,String file1,String file2){
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(file1+" "+file2);
        String time = new Date().toString();
        message.setSendTime(time);
        message.setMesType(MessageType.MESSAGE_FILE);
        System.out.println(time+sender+"向"+getter+"发送文件 ");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

















