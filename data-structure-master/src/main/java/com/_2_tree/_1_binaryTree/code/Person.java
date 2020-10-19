package com._2_tree._1_binaryTree.code;

/**
 * 数据
 * @author : Mr-Z
 * @date : 2020/10/19 23:15
 */
public class Person  implements Comparable<Person>{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return "age=" + age;
    }
}
