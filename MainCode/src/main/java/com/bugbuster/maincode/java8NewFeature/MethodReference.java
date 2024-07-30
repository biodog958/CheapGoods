package com.bugbuster.maincode.java8NewFeature;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 新特性1:方法引用
 * foreach会将容器中的元素传递过去，因此调用的方法必须能将对象消费了
 * 1.构造器引用：Class::new
 * 2.静态方法引用  Class::StaticMethod  静态方法必须有传入参数，且为集合中传递过去的类型
 * 3.特定对象的实例方法 Class::InstanceMethodName, 实际上会将类作为一个参数传递，也就是函数式接口的抽象方法至少得有一个参数
 * 4.实例的方法引用：Instance::InstanceMethodName 也必须有一个参数，且为foreach传递过去的类型
 */
public class MethodReference {


    public static void main(String[] args) {
        List<TestMethodReference> container = new ArrayList<>();
        container.add(new TestMethodReference());
        container.forEach(TestMethodReference::printSth);
        TestMethodReference testMethodReference = new TestMethodReference();
        container.forEach(testMethodReference::instanceMethod);
        container.forEach(TestMethodReference::otherMethod);




    }
}

class TestMethodReference {

    public static void printSth(TestMethodReference testMethodReference){
        System.out.println("这是静态方法"+testMethodReference.toString());
    }

    public void otherMethod(){
        System.out.println("这是一般方法");
    }

    public void instanceMethod(TestMethodReference testMethodReference){
        System.out.println("这是实例方法"+testMethodReference);
    }
}


