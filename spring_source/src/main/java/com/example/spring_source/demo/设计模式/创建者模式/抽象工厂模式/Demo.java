package com.example.spring_source.demo.设计模式.创建者模式.抽象工厂模式;


/**
 * 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象。
 */
public class Demo {
    public static void main(String[] args) {


    }

    //测试浅拷贝
    public static void test1(){
        Person person = new Person();

        Object clonePerson = null;
        try {
            clonePerson = person.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person == clonePerson);
    }

    //测试深拷贝
    public static void test2(){
        Person person = new Person();

        Object clonePerson = null;
        try {
            clonePerson = person.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person == clonePerson);
    }
}




class Person implements Cloneable{
    /**
     * 浅拷贝
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Animal implements Cloneable{
    /**
     * 浅拷贝
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    private Person person;

}