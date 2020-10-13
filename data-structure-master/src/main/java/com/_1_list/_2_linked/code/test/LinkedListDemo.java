package com._1_list._2_linked.code.test;

import com._1_list._2_linked.code.LinkedList;
import com._1_list._2_linked.code.List;

/**
 * LinkedList测试
 * @author : Mr-Z
 * @date : 2020/10/11 18:14
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        System.out.println("LinkedListDemo.main");
        List <Integer> list = new LinkedList <>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);
        list.remove(1);
        System.out.println(list);
    }
}
