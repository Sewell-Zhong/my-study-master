package com._3_algorithm._1_sort._6_quick_sort.code.SortClass;

public class InsertionSort1<E  extends Comparable<E>> extends Sort<E> {
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur >0 && cmp(cur,cur - 1) < 0) {
                swap(cur,cur - 1);
                cur--;
            }
        }
    }


}
