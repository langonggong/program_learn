package com.lanxu.study.lambda;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月05 00:22
 **/
@RunWith(JUnit4.class)
public class Test1 {

  public String[] getPlayers() {
    String[] players = {"Rafael Nadal", "Novak Djokovic",
        "Stanislas Wawrinka", "David Ferrer",
        "Roger Federer", "Andy Murray",
        "Tomas Berdych", "Juan Martin Del Potro",
        "Richard Gasquet", "John Isner"};
    return players;
  }

  public List<Person> getJavaProgrammers() {
    List<Person> javaProgrammers = new ArrayList<Person>() {
      {
        add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
        add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
        add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
        add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
        add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
        add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
        add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
        add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
        add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
        add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
      }
    };
    return javaProgrammers;
  }

  public List<Person> getPhpProgrammers() {
    List<Person> phpProgrammers = new ArrayList<Person>() {
      {
        add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
        add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
        add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
        add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
        add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
        add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
        add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
        add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
        add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
      }
    };
    return phpProgrammers;
  }

  @org.junit.Test
  public void base() {
    List<String> players = Arrays.asList(getPlayers());
    players.forEach(player -> System.out.println(player + ";"));
  }

  @org.junit.Test
  public void innerClass() {
    new Thread(() -> System.out.println("hello world!")).start();
    Runnable runnable = () -> System.out.println("let us run");
    runnable.run();
  }


  @org.junit.Test
  public void sort() {
    String[] players = getPlayers();
    Arrays.sort(players, (String str1, String str2) -> (str1.substring(str1.indexOf(" "))
        .compareTo(str2.substring(str2.indexOf(" ")))));
    Arrays.asList(players).forEach(player -> System.out.println(player));
  }

  @org.junit.Test
  public void consumer() {
    Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() * 5 + e.getSalary());
    List<Person> javas = getJavaProgrammers();
    javas.forEach(javaProgrammer -> System.out.println(javaProgrammer.getSalary() + "\t"));
    javas.forEach(giveRaise);
    javas.forEach(javaProgrammer -> System.out.println(javaProgrammer.getSalary() + "\t"));
  }

  @org.junit.Test
  public void stream() {
    getPhpProgrammers().stream().filter((p) -> (p.getSalary() > 1500)).forEach((p) -> System.out
        .println(p.getFirstName() + " " + p.getLastName()));
  }

  @org.junit.Test
  public void predicate() {
    Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
    Predicate<Person> salaryFilter = (p) -> ((p.getSalary() > 1400));
    Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

    getPhpProgrammers().stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter)
        .forEach((p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));
  }

  @org.junit.Test
  public void minAndMax() {
    Person low = getPhpProgrammers().stream().min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
        .get();
    System.out.println(low);
    Person high = getPhpProgrammers().stream().max((p1, p2) -> (p1.getSalary() - p2.getSalary()))
        .get();
    System.out.println(high);
  }

  // TODO: 2017/12/5
  @org.junit.Test
  public void collect() {

  }

  @org.junit.Test
  public void parallel() {
    int totalSalary = getJavaProgrammers().stream().mapToInt(p -> p.getSalary()).sum();
    System.out.println(totalSalary);
  }

  @org.junit.Test
  public void groupingBy() {
    Map<String, Integer> result = getJavaProgrammers().parallelStream().filter(
        p -> p.getAge() >= 25 && p.getAge() <= 35).collect(Collectors.groupingBy(
        p -> p.getGender(), Collectors.summingInt(p -> 1)));
    System.out.println(result);
  }

  class Person {
    private String firstName, lastName, job, gender;
    private int age, salary;

    public Person(String firstName, String lastName, String job, String gender, int age, int
        salary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.job = job;
      this.gender = gender;
      this.age = age;
      this.salary = salary;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getJob() {
      return job;
    }

    public void setJob(String job) {
      this.job = job;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public int getSalary() {
      return salary;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", job='" + job + '\'' +
          ", gender='" + gender + '\'' +
          ", age=" + age +
          ", salary=" + salary +
          '}';
    }
  }
}