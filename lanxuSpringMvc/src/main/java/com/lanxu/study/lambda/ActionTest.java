package com.lanxu.study.lambda;

import com.lanxu.study.lambda.actions.Action;
import com.lanxu.study.lambda.actions.Action2;
import com.lanxu.study.lambda.actions.Action3;
import com.lanxu.study.lambda.model.Model;
import com.lanxu.study.lambda.model.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月06 17:24
 **/
@RunWith(JUnit4.class)
public class ActionTest {

  public static String test(int i) {
    return "i=" + i;
  }

  //Functional接口
  @Test
  public void action2Test() {
    Action2<String, Integer> a2 = (f) -> ("this is " + f);
    System.out.println(a2.run(3));
  }

  //使用 :: 关键字来传递方法(静态方法和非静态方法)
  @Test
  public void action3Test() {
    Action3 a = Integer::toBinaryString;
    Action3 b = ActionTest::test;
    System.out.println(a.run(2));
    System.out.println(b.run(3));
  }

  //接口中带泛型
  @Test
  public void actionTest() {
    Model m = new Model();
    //方法有一个参数，然后没返回类型,这里参数类型会自动识别
    Action<Model> a = (s) -> System.out.println("hello");
    a.run(m);

    //注意:如果这里泛型类型不是Model 那么就不能引用Model中的方法
    //可以引用Model类中任意方法 只要满足一点:该方法没有参数
    //将来run方法中就会调用Model类型对象m的此处引用的方法
    Action<Model> a1 = Model::test1;
    Action<Model> a3 = Model::test3;
    a1.run(m);
    a3.run(m);

    //引用对象m中的test2、Model中的test4方法
    //因为test2、test4方法的参数和返回类型和Action接口的方法完全一致
    Action<Model> a2 = m::test2;
    a2.run(m);
    Action<Model> a4 = Model::test4;
    a4.run(m);

  }

  //Predicate接口
  @Test
  public void PredicateTest() {
    List<String> languages = Arrays.asList("Java", "html5", "JavaScript", "C++", "hibernate",
        "PHP");
    //名字以J开头并且长度大于4的
    Predicate<String> c1 = (name) -> name.startsWith("J");
    Predicate<String> c2 = (name) -> name.length() > 4;
    languages.stream().filter(c1).filter(c2).forEach((p) -> System.out.println(p));
  }

  //Function有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法
  // compose方法表示在某个方法之前执行
  // andThen方法表示在某个方法之后执行
  @Test
  public void FunctionTest() {
    String name = "tom";
    /*使用用户的输入的名字创建一个对象*/
    Function<String, Student> f = (s) -> new Student(s);
    Function<String, String> before = (s) -> {
      System.out.println("execute before");
      return "before" + s;
    };
    Function<Student, Integer> after = (s) -> {
      System.out.println("execute after");
      return s.getName().length();
    };
    System.out.println(f.compose(before).andThen(after).apply(name));
  }

  @Test
  public void test111() {
    List<Student> list = new ArrayList<>();
    Student student1 = new Student("lan");
    Student student2 = new Student("aaa");
    Student student3 = new Student("b");
    Student student4 = new Student("dd");
    list.add(student1);
    list.add(student2);
    list.add(student3);
    list.add(student4);

    List<Student> preferred = list.stream().filter(s -> s.getName().length() > 2).collect
        (Collectors.toList());
  }

  @Test
  public void BinaryOperatorTest() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    BinaryOperator<Integer> operator = (i1, i2) -> {
      System.out.println(i1 + " add " + i2);
      return i1 + i2;
    };
    operator.apply(1, 2);
  }

  @Test
  public void OptionalTest() {
    Optional<String> optional = Optional.ofNullable(null);
    System.out.println(optional.orElse("default"));
  }

}