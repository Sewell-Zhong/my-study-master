package com._3_algorithm._1_sort._5_merge_sort.code.SortClass;

public class SelectionSort<E  extends Comparable<E>> extends Sort {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end ; begin++) {
                if (cmp(maxIndex,begin) <= 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex,end);
        }
    }
}
