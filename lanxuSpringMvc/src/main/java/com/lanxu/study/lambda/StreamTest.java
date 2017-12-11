package com.lanxu.study.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月07 17:59
 **/
@RunWith(JUnit4.class)
public class StreamTest {

  //map映射,把Stream中的每一个元素,映射成另外一个元素
  @Test
  public void mapTest() {
    //转换大写
    Stream.of("wuhan", "chengdu", "hangzhou").map(String::toUpperCase).
        collect(Collectors.toList()).forEach(System.out::println);
    //计算平方数
    Stream.of(1, 2, 3, 4, 5).map((i) -> (i * i)).collect(Collectors.toList()).
        forEach(System.out::println);
  }

  //flatMap,一对多映射关系
  @Test
  public void flatMapTest() {
    Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6)).
        flatMap((e) -> e.stream()).forEach(System.out::println);
    Stream.of("xu.lan", "Jack.ma").flatMap((s) -> Stream.of(s.split("[.]"))).forEach(System
        .out::println);
  }

  //规约/合并
  @Test
  public void reduceTest() {
    System.out.println(IntStream.range(1, 11).reduce(Integer::sum).getAsInt());
    System.out.println(Stream.of("A", "B", "C", "D").reduce(String::concat).get());
    System.out.println(Stream.of("A", "B", "C", "D").reduce("", String::concat));
    System.out.println(Arrays.asList("test", "javap", "hello", "world", "java", "tom", "C",
        "javascript").stream().sorted((s1, s2) -> s1.length() - s2.length()).filter(s -> s
        .startsWith("j")).map(s -> s + "_briup").reduce((s1, s2) -> s1 + "|" + s2).get());
  }

  //generate
  @Test
  public void generateTest() {
    Stream.generate(() -> (int) (Math.random() * 100)).limit(10).forEach(System.out::println);
  }

  //迭代
  @Test
  public void iterateTest() {
    System.out.println(Stream.iterate(1, n -> n + 1).limit(10).reduce(Integer::sum).get());
  }

  //Collectors
  @Test
  public void CollectorsTest() {
    Arrays.asList("test", "hello", "world", "java", "tom", "C", "javascript").stream().filter(s -> s
        .length() > 4).collect(Collectors.toList()).forEach(System.out::println);
    Map<Integer, List<String>> collect = Arrays.asList("test", "hello", "world", "java", "tom",
        "C", "javascript").stream().collect(Collectors.groupingBy(String::length));
    Map<Boolean, List<String>> collect2 = Arrays.asList("test", "hello", "world", "java", "tom",
        "C", "javascript").stream().collect(Collectors.partitioningBy(s -> s.contains("java")));
  }

}