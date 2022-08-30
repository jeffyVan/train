package com.jeffy.qqserver;

import com.jeffy.qqcommon.Message;

import java.util.*;

public class ManageServerConnectClientThread {
    //存放服务器端的线程集合
    private static HashMap<String,ServerConnectClientThread> hashMap=new HashMap<>();

    public static HashMap<String, ArrayList<Message>> lxMessage = new HashMap<>();//存放离线消息

    //添加
    public static void addServerConnectClientThread(String userId,ServerConnectClientThread thread){
        hashMap.put(userId,thread);
    }

    //根据id获取线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hashMap.get(userId);
    }



    //获取在线用户
    public static String getAllId(){
        Set<String> keySet = hashMap.keySet();
        String s="";
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            s+=next+" ";
        }
        return s;
    }

    //用户退出
    public static void exit(String userId){
        hashMap.remove(userId);
    }


}
