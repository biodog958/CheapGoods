package com.bugbuster.maincode;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.sql.SQLOutput;
import java.util.stream.Stream;

public class Streamtest {
    public static void main(String[] args) {
//        创建无限流
        Stream<Integer> limit = Stream.iterate(1, x -> x + 2).limit(5);
        limit.forEach(System.out::println);


    }
}
