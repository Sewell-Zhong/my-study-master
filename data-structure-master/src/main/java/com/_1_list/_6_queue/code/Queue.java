package com._1_list._6_queue.code;


import com._1_list._6_queue.code.LinkedList.LinkedList;
import com._1_list._6_queue.code.LinkedList.List;

/**
 * 队列
 *
 * @author : Mr-Z
 * @date : 2020/10/15 0:06
 */
public class Queue<E> {

    private List <E> list = new LinkedList <>();

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 获取队列的头元素
     *
     * @return
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 清空
     */
    public void clear() {
        list.clear();
    }
}
