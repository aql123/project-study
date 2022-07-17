package com.reflection;

/**
 * @Describe  测试Class类的创建方式有哪些
 * @Author aiqiulin
 * @Date 2022/7/17 0:38
 */
public class Test03 {

}

class Person{
  public     String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
