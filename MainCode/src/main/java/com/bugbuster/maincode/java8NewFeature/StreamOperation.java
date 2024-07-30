package com.bugbuster.maincode.java8NewFeature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 新特性3:Stream流
 * 流的来源：
 * 1.集合：queue，set,list
 * 2.数组：Array
 * 3.静态工厂方法：Stream.of
 * 4.files中创建流 Files.lines(path);
 * 5.Stream.iterate(起始值,变化规则） ex:Stream.iterate(0,x->x+1)
 * 6.Stream.generate()
 * 7.BufferReader.lines();
 *
 */
public class StreamOperation {
    public static void main(String[] args) throws URISyntaxException {
        //1.集合
        Set<String> testSet = new HashSet<>();
        testSet.add("li");
        testSet.add("yuan");
        testSet.add("jiang");
        Stream<String> stream = testSet.stream();
        stream.forEach(x-> System.out.println(x));

        //2.数组
        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.addAll(testSet);
        Stream<String> stream1 = testArrayList.stream();
        stream1.forEach(System.out::println);

        //3。静态工厂方法
        Stream<String> a = Stream.of("a", "b", "","c");
        a.filter(x->x!="").forEach(System.out::println);

        //4.files
        Path path = Paths.get(ClassLoader.getSystemResource("file.txt").toURI());
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //5.readerBuffer
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            Stream<String> lines = reader.lines();
            lines.forEach(x -> System.out.println(x));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //6.Stream.iterate
        Stream<Integer> iterate = Stream.iterate(0, x -> ++x).limit(5);
        iterate.forEach(x -> System.out.println(x));

        //7.Stream.generate
        Stream<Double> generate = Stream.generate(Math::random).limit(5);
        generate.forEach(x->{x= x*10;
            System.out.println(x);});




    }
}
