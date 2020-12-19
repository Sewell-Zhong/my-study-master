package com._3_algorithm._1_sort._1_bobble_sort.code;

import com._3_algorithm._1_sort._1_bobble_sort.code.tools.Integers;
import com._3_algorithm._1_sort._1_bobble_sort.code.tools.Times;
import com._3_algorithm._1_sort._1_bobble_sort.code.tools.Times.Task;

/**
 * @author : Mr-Z
 * @date : 2020/12/18 22:50
 */
public class BubbleSort2 {


    public static void main(String[] args) {
        final Integer[] array1 = Integers.tailAscOrder(1,10000,2000);
        Times.test("bubbleSort",new Task(){
            @Override
            public void execute() {
                bubbleSort2(array1);
            }
        });
    }
    public static void bubbleSort2(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;//该值在数组完全女友许的时候有用
            for (int begin = 1; begin <= end ; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
