package com._3_algorithm._1_sort._8_counting_sort.code;


import com._3_algorithm._1_sort._8_counting_sort.code.SortClass.Cmp.*;
import com._3_algorithm._1_sort._8_counting_sort.code.SortClass.CountingSort;
import com._3_algorithm._1_sort._8_counting_sort.code.tools.Asserts;
import com._3_algorithm._1_sort._8_counting_sort.code.tools.Integers;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
       // binarySearchIndexTest();
//        binarySearchSearchTest();

        Integer[] array = Integers.random(30000,1,30000);
        testSorts(array,
        new CountingSort(),
        new InsertionSort3(),
        new BubbleSort3(),
        new SelectionSort(),
        new HeapSort(),
        new MergeSort(),
        new ShellSort(),
        new QuickSort()
        );
    }

    static void binarySearchSearchTest(){
        int[] array = {2,4,8,8,8,12,14};
        Asserts.test(BinarySearch.search(array,5) == 2);
        Asserts.test(BinarySearch.search(array,1) == 0);
        Asserts.test(BinarySearch.search(array,15) == 7);
        Asserts.test(BinarySearch.search(array,8) == 5);
    }
    static void binarySearchIndexTest() {

        int[] array = {2,4,6,8,10};
        Asserts.test(BinarySearch.indexOf(array,6) == 2);
        Asserts.test(BinarySearch.indexOf(array,2) == 0);
        Asserts.test(BinarySearch.indexOf(array,10) == 4);
        Asserts.test(BinarySearch.indexOf(array,56) == -1);

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
