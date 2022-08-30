package com.jeffy.qqclient;

import java.util.Scanner;

public class View {

    private boolean loop = true;
    private Scanner sc = new Scanner(System.in);
    private UserClientService userClientService=new UserClientService();

    public void m1() {
        while (loop) {
            System.out.println("===============QQ用户端系统===================");
            System.out.println("\t\t1.登录系统");
            System.out.println("\t\t9.退出系统");
            System.out.println("请输入您的选择：");
            String s = sc.nextLine();//用户输入选择
            switch (s) {
                case "1"://登录系统
                    login();
                    loop=true;
                    break;
                case "9"://退出系统
                    System.out.println("退出系统");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，重新输入");
            }

        }
    }

    private void login() {
        System.out.println("请输入用户ID\t:");
        String userID = sc.nextLine();
        System.out.println("请输入用户密码\t:");
        String password = sc.nextLine();



        if (userClientService.checkUser(userID,password)) {//登录成功
            loginSucced(userID);


        } else {//登录失败
            System.out.println("用户名或者密码错误！");
            login();
        }
    }

    private void loginSucced(String userID) {
        System.out.println("============欢迎" + userID + "===============");

        while (loop) {
            System.out.println("================QQ客户端系统二级菜单=========================");
            System.out.println("\t\t1.显示在线用户列表");
            System.out.println("\t\t2.群发消息");
            System.out.println("\t\t3.私聊消息");
            System.out.println("\t\t4.发送文件");
            System.out.println("\t\t9.退出系统");
            System.out.println("请输入您的选择：");
            String line = sc.nextLine();
            switch (line) {
                case "1"://显示在线用户列表
                    userClientService.getOnlineList();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2"://群发消息
                    System.out.print("请输入想群发的内容：");
                    String textToAll = sc.nextLine();
                    userClientService.chatToAll(userID,textToAll);
                    break;
                case "3"://私聊消息
                    System.out.print("请输入想聊天的用户ID（在线）：");
                    String wantToChatUserId = sc.nextLine();
                    System.out.print("请输入想说的话：");
                    String text = sc.nextLine();
                    userClientService.chatToUser(wantToChatUserId,text);
                    break;
                case "4"://发送文件
                    System.out.print("请输入想对那个用户（在线）发送文件：");
                    String fileGetter = sc.nextLine();
                    System.out.print("发送文件的路径：（形式：d:\\xxx.jpg）：");
                    String file1 = sc.nextLine();
                    System.out.print("接收文件的路径：（形式：d:\\xxx.jpg）：");
                    String file2 = sc.nextLine();
                    userClientService.sendFile(userID,fileGetter,file1,file2);
                    break;
                case "9"://退出系统
                    loop=false;
                    System.out.println("退出系统");
                    userClientService.exit();
                    System.exit(0);
                    break;
                default://输入错误
                    System.out.print("输入错误，重新输入");
                    break;

            }
        }

    }


}
