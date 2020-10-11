package com.list.twoWayLinked.code.Single;


import com.list.twoWayLinked.code.AbstractList;

/**
 * 单向链表（增加虚拟头节点）
 * @author : Mr-Z
 * @date : 2020/10/12 0:50
 */
public class SingleLinkedList2<E> extends AbstractList <E> {
    /**
     * 首节点
     */
    private Node first;

    public SingleLinkedList2() {
        first = new Node<>(null,null);
    }

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
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        System.out.println("index == " + index);
            Node<E> prev = index == 0 ? first : node(index - 1);
            prev.next = new Node<>(element,prev.next);

        size++;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        Node<E> prev = index == 0 ? first : node(index - 1);
        node = prev.next;
        prev.next = node.next;
        size--;
        return node.element;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null){
                    return i;
                }
                node = node.next;
            }
        } else  {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)){
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 通过索引获取对应的节点
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
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
        E element;
        Node <E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 自定义系统打印
     */
    @Override
    public String toString() {
        //希望拼接的格式为 size = 9，[99,12,13]
        StringBuilder string = new StringBuilder();
        Node<E> node = first.next;
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                //推荐使用
                string.append(", ");
            }
            string.append(node.element);
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
