package com._3_algorithm._1_sort._9_radix_sort.code;

public class Student implements Comparable<Student>{
    public int score;
    public int age;
    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }
    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
