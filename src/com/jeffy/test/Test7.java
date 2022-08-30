package com.jeffy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test7 {
    public static void main(String[] args) {
        String str = "Java 是由 Sun Microsystems 公司于 1995 年 5 月推出的高级程序设计语言。" +
                "Java 可运行于多个平台，如 Windows, Mac OS 及其他多种 UNIX 版本的系统。\n" +
                "本教程通过简单的实例将让大家更好的了解 Java 编程语言。" +
                "移动操作系统 Android 大部分的代码采用 Java 编程语言编程。";

        Pattern p = Pattern.compile("Java\\d{0,2}");
        Matcher m = p.matcher(str);
        while (m.find()){
            System.out.println(m.group());
        }

    }
}
