package com.jeffy.qqserver;

import com.jeffy.qqcommon.Message;
import com.jeffy.qqcommon.MessageType;
import com.jeffy.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {
    private ServerSocket serverSocket = null;
    //存放合法的用户数据
    private static HashMap<String,User> userHashMap=new HashMap<>();

    static {
        userHashMap.put("100",new User("100","123456"));
        userHashMap.put("200",new User("200","123456"));
        userHashMap.put("300",new User("300","123456"));
        userHashMap.put("400",new User("400","123456"));
        userHashMap.put("500",new User("500","123456"));
        userHashMap.put("600",new User("600","123456"));
    }

    private boolean checkUser(String userId,String pwd){
        User user = userHashMap.get(userId);
        if(user==null){
            return false;
        }
        if(!user.getUserId().equals(userId)||!user.getPassword().equals(pwd)){
            return false;
        }
        return true;
    }
    public QQServer() {
        try {
            System.out.println("服务器端在9999端口监听··");
            serverSocket = new ServerSocket(9999);
            //推送新闻的线程
            new SendNewToAllUserThread().start();

            while (true) {//一直监听
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();

                Message message = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if (checkUser(user.getUserId(), user.getPassword())) {
                    //登录验证合法
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //创建线程
                    ServerConnectClientThread thread = new ServerConnectClientThread(socket, user.getUserId());
                    thread.start();
                    //线程加入到集合
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), thread);
                } else {
                    //登录失败
                    System.out.println("用户:"+user.getUserId()+"密码"+user.getPassword()+"登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //退出while，不再监听，就关闭
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
