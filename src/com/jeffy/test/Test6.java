package com.jeffy.test;

public class Test6 {
    public static void main(String[] args) {

        String regex1 = "\\w+@[\\w&&[^_]]{2,7}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("1085385069@qq.com".matches(regex1));

        String regex2 = "((ht|f)tps?:\\/\\/)?[\\w-]+(\\.[\\w-]+)+:\\d{1,5}";
        System.out.println("https://hao.360.com:3360".matches(regex2));


        String regex3="\\w{4,16}";
        System.out.println("dhagdg_123".matches(regex3));

        String regex4="\\d{17}[\\dxX]";
        System.out.println("44051420010602541X".matches(regex4));

//[1-9]\d{5}((1[89])|(20))
        String regex5="[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]";
        System.out.println("19524520990231456X".matches(regex5));
    }
}
