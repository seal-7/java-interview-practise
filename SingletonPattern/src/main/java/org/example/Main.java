package org.example;

import org.example.models.SingletonClass;
import org.example.models.Student;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Student s = new Student(1, "Raj");
        int x = 10;
        System.out.println(System.identityHashCode(x));
        updateStudent(s, x);
        System.out.println(s.getId());
        System.out.println(s.getName());

//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<20;i++) {
//                    System.out.println(SingletonClass.getInstance().hashCode());
//                }
//            }
//        };
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<20;i++) {
//                    System.out.println(SingletonClass.getInstance().hashCode());
//                }
//            }
//        };
//
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
    }

    public static void updateStudent(Student s, int x) {
        System.out.println(System.identityHashCode(x));
        Student s2 = new Student(2, "Ruta");
        s = s2;
    }
}