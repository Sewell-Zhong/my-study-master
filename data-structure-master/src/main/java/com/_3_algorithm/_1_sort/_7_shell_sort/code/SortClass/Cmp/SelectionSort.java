package com._3_algorithm._1_sort._7_shell_sort.code.SortClass.Cmp;

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
