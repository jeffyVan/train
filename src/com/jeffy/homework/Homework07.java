package com.jeffy.homework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Homework07 {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o = constructor.newInstance("E:\\aaaa.txt");

        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);

    }
}
