package com._1_list._6_queue.code.Circle;

/**
 * 循环双端队列
 *
 * @author : Mr-Z
 * @date : 2020/10/14 23:57
 */
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
    /**
     * 存储队头元素的下标
     */
    private              int front;
    /**
     * 存储所有元素的大小
     */
    private              int size;
    /**
     * 元素数组
     */
    private              E[] elements;
    /**
     * 默认初始化大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从尾部入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size+1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 从头部出队
     *
     * @return
     */
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 从头部入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size+1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从尾部出队
     *
     * @return
     */
    public E deQueueRear() {
        int rearIndex = index(size-1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    /**
     * 获取队头元素
     *
     * @return
     */
    public E front() {
        return elements[front];
    }

    /**
     * 获取队尾元素
     *
     * @return
     */
    public E Rear() {
        return elements[index(size-1)];
    }

    /**
     * 自定义打印
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capcacity=").append(elements.length).append(" size=").append(size).append(" front=").append(front).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 转换索引(例如队头元素[0]，不一定位于数组的[0]下标，这里进行一次转换)
     *
     * @param index
     * @return
     */
    private int index(int index) {
        index += front;
        if (index < 0) {
            return index+elements.length;
        }
        return index-(index >= elements.length ? elements.length : 0);
    }

    /**
     * 数组扩容 保证要有capacity的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity < capacity) {
            //确定新的容量  新容量为旧容量的1.5倍
            int newCapacity = oldCapacity+(oldCapacity >> 1);
            //创建一个更大存储空间的数组
            E[] newElements = (E[]) new Object[newCapacity];
            //将原来数组中的元素，复制到新的数组中
            for (int i = 0; i < size; i++) {
                //获取数组中的真实索引
                newElements[i] = elements[index(i)];
            }
            elements = newElements;
            front = 0;
        }
    }
}
