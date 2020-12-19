package com._3_algorithm._1_sort._3_heap_sort.code.SortClass;

public class BubbleSort3 extends Sort{

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;//该值在数组完全逆序许的时候有用
            for (int begin = 1; begin <= end ; begin++) {
                if (cmp(begin,begin - 1) < 0) {
                   swap(begin,begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
