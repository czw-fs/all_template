package com.example.spring_source.main;

import com.example.spring_source.entity.Student;
import io.micrometer.common.util.StringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DemoMain  {

//;生成测试代码

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("张三"));
        students.add(new Student());
        students.add(new Student("王五"));

       String coordinatorName = coordinatorName = students.stream().map(Student::getName).filter(StringUtils::isNotBlank).collect(Collectors.joining("、"));
        System.out.println("coordinatorName = " + coordinatorName);

    }
}

// 接口 Drink.java
@Data
abstract class Drink {
    public String des;//描述
    private float price = 0.0f;
    // get / set方法略

    //计算费用的抽象方法：由子类实现
    public abstract float cost();
}

// CoffeeDemo.java
class CoffeeDemo extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}

// Espresso.java/LongBlack.java/ShortBlack.java
 class Espresso extends CoffeeDemo {
    public Espresso() {
        setDes("意大利咖啡");
        setPrice(10.0f);
    }
}

// Decorator.java  继承Drink又组合Drink
 class Decorator extends Drink{
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        //自己(调料)的价格+咖啡的价格
        return super.getPrice() + drink.getPrice();
    }

    @Override
    public String getDes() {
        //父类的信息+被装饰者的信息
        return super.des + drink.getDes();
    }
}
// Chocolate.java/Milk.java/Soy.java
//具体的Decorator，这里就是调味品
 class Chocolate extends Decorator {
    public Chocolate(Drink drink) {//必须有构造器
        super(drink);
        setDes("巧克力");
        setPrice(1.0f);
    }
}
// CoffeeDemoBar.java 使用
class CoffeeDemoBar {
    public static void main(String[] args) {

        Drink CoffeeDemo = new Espresso();

        CoffeeDemo = new Chocolate(CoffeeDemo);
        System.out.println("加入一份牛奶+巧克力后："+CoffeeDemo.getDes()+" 价格:"+CoffeeDemo.cost());

        CoffeeDemo = new Chocolate(CoffeeDemo);
        System.out.println("加入一份牛奶+2份巧克力后："+CoffeeDemo.getDes()+" 价格:"+CoffeeDemo.cost());
    }
}


