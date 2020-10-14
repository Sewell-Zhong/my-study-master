package com._1_list._6_queue.code;


import com._1_list._6_queue.code.LinkedList.LinkedList;
import com._1_list._6_queue.code.LinkedList.List;

/**
 * 双端队列
 * @author : Mr-Z
 * @date : 2020/10/15 0:05
 */
public class Deque<E> {
    private List <E> list = new LinkedList <>();

    /**
     * 元素的数量
     * @return
     */
    public int size() {
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
     * 从队尾入队
     * @param element
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    /**
     * 从队头出队
     * @return
     */
    public E deQueueFront() {
        return list.remove(0);
    }

    /**
     * 从队头入队
     * @param element
     */
    public void enQueueFront(E element) {
        list.add(0,element);
    }

    /**
     * 从队尾出队
     * @return
     */
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    /**
     * 获取队列的头元素
     * @return
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 获取队列的尾元素
     * @return
     */
    public E Rear() {
        return list.get(list.size() - 1);
    }
}
