package com.jeffy.qqcommon;

public interface MessageType {
    //接口中定义常量，表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED="1";//登录成功
    String MESSAGE_LOGIN_FAIL="2";//登录失败
    String MESSAGE_COM_MES="3";//普通消息
    String MESSAGE_GET_ONLINE_LIST="4";//获取在线列表
    String MESSAGE_RET_ONLINE_LIST="5";//返回列表
    String MESSAGE_CLIENT_EXIT="6";//退出
    String MESSAGE_CHAT_ALL="7";//群发
    String MESSAGE_FILE="8";//文件

}
