package com.example.spring_source.demo.设计模式.创建者模式.原型模式;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 对象的创建非常复杂，可以使用原型模式快捷的创建对象。
 * 性能和安全要求比较高。
 */

public class Demo {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    //浅拷贝
    public static void test1() {
        Person person = new Person();

        Person clonePerson = null;
        try {
            clonePerson = person.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(person == clonePerson);//false
    }

    //深拷贝
    public static void test2() {
        Person person = new Person();
        person.setStudent(new Student());

        Person clonePerson = null;
        try {
            clonePerson = person.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person.getStudent() == clonePerson.getStudent());//true

        Person deepPerson = DeepCloneUtil.deepClone(person);

        System.out.println(person.getStudent() == deepPerson.getStudent());//false

    }
}

@Data
class Person implements Cloneable , Serializable {

    @Serial
    private static final long serialVersionUID = -5461562539764872674L;

    private Student student;

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

class Student implements Serializable{

    @Serial
    private static final long serialVersionUID = 5072357874358815934L;
}

