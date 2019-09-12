package com.enthusiast91.webapp;

import com.enthusiast91.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println("Field name: " + field.getName());
        System.out.println("Old uuid resume: " + field.get(r));

        System.out.println("\nChanging uuid resume through reflection.");
        field.set(r, "new_uuid");
        System.out.println("New uuid resume: " + field.get(r));

        System.out.println("\nInvoking method toString through reflection.");
        Method method = Object.class.getMethod("toString");
        System.out.println(method.invoke(r));
    }
}