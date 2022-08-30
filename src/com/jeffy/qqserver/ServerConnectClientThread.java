package com.jeffy.qqserver;


import com.jeffy.qqcommon.Message;
import com.jeffy.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;



    public Socket getSocket() {
        return socket;
    }

    public String getUserId() {
        return userId;
    }

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true) {
            try {

                HashMap<String, ArrayList<Message>> lxMessage = ManageServerConnectClientThread.lxMessage;//离线消息

                //查看是否有离线消息，有就发送
                if (lxMessage.get(userId) != null) {
                    System.out.println("向" + userId + "发送离线消息");
                    ArrayList<Message> messages = lxMessage.get(userId);
                    for (int i = 0; i < messages.size(); i++) {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(messages.get(i));
                        Thread.sleep(1000);
                    }
                    lxMessage.remove(userId);
                }

                //循环读取客户端发来的消息
                System.out.println("服务器和用户端" + userId + "保持通信");
                //输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message outMessage = new Message();


                String mesType = message.getMesType();//数据类型




                //判断消息类型
                if (mesType.equals(MessageType.MESSAGE_GET_ONLINE_LIST)) {
                    System.out.println(userId + "拉取在线用户列表");
                    //获取用户列表
                    //传输对象，在线用户列表
                    outMessage.setMesType(MessageType.MESSAGE_RET_ONLINE_LIST);
                    String allId = ManageServerConnectClientThread.getAllId();
                    outMessage.setContent(allId);
                    outMessage.setGetter(message.getSender());
                    oos.writeObject(outMessage);
                } else if (mesType.equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(userId + "退出系统");
                    //用户退出
                    ManageServerConnectClientThread.exit(userId);
                    socket.close();
                    break;
                } else if (mesType.equals(MessageType.MESSAGE_COM_MES)) {
                    System.out.println(userId + "想与" + message.getGetter() + "私聊");
                    //用户私聊
                    ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter());
                    if (thread == null) {//用户不在线
                        System.out.println(message.getGetter() + "用户不在线,先保存消息");

                        if (lxMessage.get(message.getGetter()) == null) {//map为空,新建集合
                            System.out.println("11111111111");
                            ArrayList<Message> messages = new ArrayList<>();
                            messages.add(message);
                            lxMessage.put(message.getGetter(), messages);

                            System.out.println(lxMessage);
                        } else {//map不为空,获取集合，加入消息
                            System.out.println("22222222222222");
                            ArrayList<Message> list = lxMessage.get(message.getGetter());
                            list.add(message);
                            lxMessage.put(message.getGetter(), list);

                            System.out.println(lxMessage);
                        }

                    } else {//用户在线

                        Socket socket = thread.getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(message);


                    }


                } else if (mesType.equals(MessageType.MESSAGE_CHAT_ALL)) {
                    System.out.println(userId + "群发消息");
                    //用户群发
                    String allId = ManageServerConnectClientThread.getAllId();
                    String[] ids = allId.split(" ");
                    for (String id : ids) {
                        if (id.equals(userId)) {
                            continue;
                        }
                        ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(id);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(thread.socket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }


                } else if (mesType.equals(MessageType.MESSAGE_FILE)) {
                    System.out.println(userId + "给" + message.getGetter() + "发送文件");
                    //发送文件
                    ServerConnectClientThread thread = ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter());
                    Socket socket = thread.getSocket();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message);

                } else {
                    System.out.println("其他操作===");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
