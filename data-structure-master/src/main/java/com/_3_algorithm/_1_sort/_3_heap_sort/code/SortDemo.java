package com._3_algorithm._1_sort._3_heap_sort.code;


import com._3_algorithm._1_sort._3_heap_sort.code.SortClass.BubbleSort3;
import com._3_algorithm._1_sort._3_heap_sort.code.SortClass.HeapSort;
import com._3_algorithm._1_sort._3_heap_sort.code.SortClass.SelectionSort;
import com._3_algorithm._1_sort._3_heap_sort.code.SortClass.Sort;
import com._3_algorithm._1_sort._3_heap_sort.code.tools.Asserts;
import com._3_algorithm._1_sort._3_heap_sort.code.tools.Integers;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        Integer[] array = Integers.random(10000,1,20000);
        testSorts(array, new HeapSort(),new SelectionSort(), new BubbleSort3());
    }

    static  void  testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort: sorts  ) {
            Integer[] newArray = Integers.copy(Integers.copy(array));
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort: sorts  ) {
            System.out.println(sort);
        }
    }
}
