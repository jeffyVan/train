package com.jeffy.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test8 {
    public static void main(String[] args) throws ParseException {

        String str="2000-11-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf1.format(date));


        String str1="2023年11月11日 0:0:0";
        String str2="2023年11月11日 0:10:0";
        String str3="2023年11月11日 0:01:0";
        String str4="2023年11月11日 0:11:0";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date1 = sdf2.parse(str1);
        Date date2 = sdf2.parse(str2);
        Date date3 = sdf2.parse(str3);
        Date date4 = sdf2.parse(str4);

        long start = date1.getTime();
        long end = date2.getTime();
        long xj = date3.getTime();
        long xp = date4.getTime();

        extracted(start, end, xj);
        extracted(start, end, xp);


    }

    private static void extracted(long start, long end, long name) {
        if(name >= start && name <= end){
            System.out.println(name+"参加活动");
        }else {
            System.out.println(name+"没参加活动");
        }
    }
}
