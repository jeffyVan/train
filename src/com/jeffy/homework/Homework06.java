package com.jeffy.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework06 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName("com.jeffy.homework.PrivateTest");
        Object o = aClass.newInstance();

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"as");
        Method getName = aClass.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }

}


class PrivateTest{
    private String name="hellokitty";

    public String getName() {
        return name;
    }
}
