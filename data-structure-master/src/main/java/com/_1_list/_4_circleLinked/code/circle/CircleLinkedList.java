package com._1_list._4_circleLinked.code.circle;


import com._1_list._4_circleLinked.code.AbstractList;

/**
 * 双向循环链表
 *
 * @author : Mr-Z
 * @date : 2020/10/13 15:12
 */
public class CircleLinkedList<E> extends AbstractList <E> {
    /**
     * 指向头节点
     */
    private Node first;

    /**
     * 指向尾节点
     */
    private Node last;

    /**
     * 用来指向某个节点
     */
    private Node <E> current;

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
     * 重置节点，将当前节点指向首节点
     */
    public void reset() {
        current = first;
    }

    /**
     * 获取下一个节点的值
     *
     * @return
     */
    public E next() {
        if (current == null) {
            return null;
        }
        current = current.next;
        return current.element;
    }

    /**
     * 删除当前节点的元素
     *
     * @return
     */
    public E remove() {
        if (current == null) {
            return null;
        }
        Node <E> next = current.next;
        E element = remove(current);
        current = next;
        return element;
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

        if (index == size) {
            Node <E> oldLast = last;
            last = new Node <>(oldLast, element, first);
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node <E> next = node(index);
            Node <E> prev = next.prev;
            Node <E> node = new Node <>(prev, element, next);
            next.prev = node;
            prev.next = node;
            if (index == 0) {
                first = node;
            }
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
        return remove(node(index));
    }

    private E remove(Node <E> node) {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node <E> prev = node.prev;
            Node <E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (node == first) {//等价于index == 0
                first = next;
            }
            if (node == last) {//等价于index == size - 1
                last = prev;
            }
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
        if (index < (size >> 1)) {
            //在左边
            Node <E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            //在右边
            Node <E> node = last;
            for (int i = size-1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }


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
        /**
         * 指向上一个节点
         */
        Node <E> prev;

        public Node(Node <E> prev, E element, Node <E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
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
