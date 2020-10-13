package com._1_list._4_circleLinked.code.circle;


import com._1_list._4_circleLinked.code.AbstractList;

/**
 * 单向循环链表
 *
 * @author : Mr-Z
 * @date : 2020/10/13 16:22
 */
public class SingleCircleLinkedList<E> extends AbstractList <E> {
    /**
     * 首节点
     */
    private Node first;

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public E set(int index, E element) {
        Node <E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        System.out.println("index == "+index);
        if (index == 0) {
            Node <E> newFirst = new Node <E>(element, first);
            //拿到最后一个节点
            Node <E> last = (size == 0) ? newFirst : node(size-1);
            last.next = newFirst;
            first = newFirst;
        } else {
            Node <E> prev = node(index-1);
            prev.next = new Node <>(element, prev.next);
        }
        size++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node <E> node = first;
        if (index == 0) {
            if (size == 1) {
                first = null;
            } else {
                //拿到最后一个节点
                Node <E> last = node(size-1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node <E> prev = node(index-1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node <E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 通过索引获取对应的节点
     *
     * @param index
     * @return
     */
    private Node <E> node(int index) {
        rangeCheck(index);
        Node <E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 节点内部类，用来存储链表中每个节点的数据
     *
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 元素
         */
        E        element;
        /**
         * 指向下一个节点
         */
        Node <E> next;

        public Node(E element, Node <E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(next.element);
            return sb.toString();
        }
    }


    /**
     * 自定义系统打印
     *
     * @return
     */
    @Override
    public String toString() {
        //希望拼接的格式为 size = 9，[99,12,13]
        StringBuilder string = new StringBuilder();
        Node <E> node = first;
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                //推荐使用
                string.append(", ");
            }
            string.append(node);
            node = node.next;
            /*
            这种方式不建议使用，因为会多一次减法运算
            if (i != size - 1) {
                string.append(", ");
            }
             */
        }
        string.append("]");
        return string.toString();
    }
}
