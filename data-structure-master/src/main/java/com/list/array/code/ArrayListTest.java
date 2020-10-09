package com.list.array.code;


/**
 * 动态数组测试
 * @author : Mr-Z
 * @date : 2020/10/9 23:41
 */
public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println("ArrayListTest.main");
        ArrayList<Integer> arrayList = new ArrayList <>();
        arrayList.add(99);
        arrayList.add(88);
        arrayList.add(77);
        arrayList.add(66);
        arrayList.add(55);
        arrayList.add(44);
        arrayList.set(3,80);
        System.out.println(arrayList);
    }

}




