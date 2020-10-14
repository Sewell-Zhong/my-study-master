package com._1_list._5_stack.code;


import com._1_list._5_stack.code.List.ArrayList;

/**
 * 栈(Stack)
 * @author : Mr-Z
 * @date : 2020/10/14 23:10
 */
public class Stack<E>  {

    private ArrayList <E> list = new ArrayList<>();

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return list.size();
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E top() {
        return list.get(list.size() - 1);
    }
}
