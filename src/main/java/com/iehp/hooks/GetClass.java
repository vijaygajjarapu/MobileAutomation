package com.iehp.hooks;

public class GetClass {
    public static Object getPageObject(String className) {
        Class classTemp = null;
        Object obj = null;
        try {
            classTemp = Class.forName("com.iehp.pageClasses." + className + "Page");
            try {
                obj = classTemp.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}