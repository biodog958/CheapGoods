package com.bugbuster.maincode.java8NewFeature;


import java.util.ArrayList;

/**
 * 新特性2:lambda表达式
 *
 * 1）与匿名类对比
 * 1.匿名类必须继承一个父类或实现一个接口，并且最多继承一个父类或实现一个接口。
 * 2.匿名类不能是抽象类。因为抽象类不能用new来创建对象，而匿名类创建时就会立即创建对象。
 * 3.匿名类不能有构造器。因为匿名类没有类名。
 * 此外：
 * 1.匿名类可以继承父类的方法，也可以重写父类的方法。
 * //这在我们用集合的Collections排序时经常用到，重写排序的方法。
 * 2.匿名类一定是内部类。
 * 3.匿名类可以访问外部类的成员变量和方法，匿名类的类体中不可以声明static成员变量
 * 和方法。
 * //这是因为匿名类在创建时会立即创建匿名类的实例，创建结束后，这个类的定义立即消失，匿名类只能使用一次。
 * 4.匿名类不能有构造器，所以匿名类创建对象时，使用的是父类的构造方法。
 *
 * 2）lambda表达式细节
 * 1.只有函数式接口的实现，能承载lambda表达式。函数式接口：只包含一个抽象方法的接口
 * 2.Lambda表达式可以省略参数的类型，java编译器能自动推断。当lambda只有一个参数需要推断类型时，参数两边的括号可以省略
 *
 */
public class LambdaExpression {
    public static void main(String[] args) {

        //匿名类测试
        AnonymousClass anonymousClass = new AnonymousClass(){
            public void method1(){
                System.out.println("这是一个匿名类方法");
            }
        };
        anonymousClass.method1();


        //lambda表达式学习
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.method1(()->System.out.println(1)); //method1 需要接受一个函数式接口，()->System.out.println(1)相当于对接口中抽象方法的实现


        //如果要实现lambdaExpression.method1(LambdaExpression::method2);的调用 则函数式接口中必须要有个LambdaExpression累的参数接受传入参数,就如同 FunctionalInterface.testMethod1


    }

    public void method1(FunctionalInterface f){
        System.out.println(f.toString());
    }

    public  void method2(){
        System.out.println("这是一个没有参数的测试方法");
    }


}

class AnonymousClass {
    public void method1(){
        System.out.println("一个测试方法");
    }
}

interface FunctionalInterface{
    public abstract void testMethod();

//    public abstract void testMethod1(LambdaExpression lambdaExpression);
}