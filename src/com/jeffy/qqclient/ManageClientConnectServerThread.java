package com.jeffy.qqclient;

import java.util.HashMap;

//管理用户的线程
public class ManageClientConnectServerThread {

    private static HashMap<String,ClientConnectServerThread> hashMap=new HashMap<>();

    //添加
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread thread){
        hashMap.put(userId,thread);
    }

    //根据id获取对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hashMap.get(userId);
    }
}
