package com.reflection;

/**
 * @Describe
 * @Author aiqiulin
 * @Date 2022/7/17 0:17
 */
//什么叫反射
public class Test02 extends Object {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的Class对象

        // 在Object类中定义了以下方法，次方法将被所有子类继承
        // public final Class getClass()
        //以上的方法返回值类型是一个Class类，此类是java反射的源头，可以通过对象反射出类的名称。

        Class c1 = Class.forName("com.reflection.User");
        System.out.println(c1);
        Class c2 = Class.forName("com.reflection.User");
        Class c3 = Class.forName("com.reflection.User");
        Class c4 = Class.forName("com.reflection.User");

        // 一个类在内存中只有一个class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中。
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());


    }
}

//实体类:pojo entity
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}


