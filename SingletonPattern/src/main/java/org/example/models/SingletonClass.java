package org.example.models;

public class SingletonClass {

    int id;
    String name;

    private static SingletonClass singletonClass;

    public static synchronized SingletonClass getInstance() {
        singletonClass =  singletonClass == null ? new SingletonClass() : singletonClass;
        return singletonClass;
    }
    private SingletonClass() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
