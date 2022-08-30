package com.jeffy.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Homework01 {
    public static void main(String[] args) {
        New n1 = new New("新冠确诊病例超干万,数百万印度教信徒赴恒河“圣浴”引民众担忧");
        New n2 = new New("男子突然想起2个月前钓的鱼还在网兜里,捞起一看証紧放生");
        New n3 = new New("祝你生日快乐");
        New n4 = new New("");

        ArrayList<New> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);

        //倒序打印
        Collections.reverse(list);
        System.out.println(list);

        Iterator<New> iterator = list.iterator();
        while (iterator.hasNext()) {
            New next =  (New)iterator.next();
            if (next.getTitle().length()>15){
                String substring = next.getTitle().substring(0, 15);
                String endString = substring + "...";
                System.out.println(endString);
            }else if(next.getTitle().length()>1&&next.getTitle().length()<16){
                System.out.println(next.getTitle());
            }else {
                System.out.println("");
            }
        }
    }
}
/**
 * 新闻类
 */
class New {

    private String title;//标题
    private String text;//内容

    public New(String title) {
        this.title = title;
    }

    public New() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }
}
