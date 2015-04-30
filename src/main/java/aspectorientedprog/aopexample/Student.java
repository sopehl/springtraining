package aspectorientedprog.aopexample;

import org.springframework.stereotype.Component;

/**
 * Created by semih on 29.04.2015.
 */
@Component("student")
public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printSomething() {
//        get logging with aop
        System.out.println("student printed something");
//        get logging with aop
    }

    public void doSometing() {
//        get logging with aop
        System.out.println("student do something");
//        get logging with aop
    }

    @Override
    public String toString() {
        return "Target toString";
    }
}
