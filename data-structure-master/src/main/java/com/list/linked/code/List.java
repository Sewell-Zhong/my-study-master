package com.list.linked.code;

/***
 * list接口
 * @author : Mr-Z
 * @date : 2020/10/11 18:09
 */
public interface List<E> {
    /**
     * 当查找元素，没有找到时返回的默认值
     */
    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /***
     * 元素的数量
     * @return
     */
    int size();

    /***
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /***
     * 是否包含某个元素
     * @param element 判断的元素
     * @return
     */
    boolean contains(E element);

    /***
     * 添加元素到尾部
     * @param element 添加的元素
     */
    void add(E element);

    /***
     * 获取index位置的元素
     * @param index 获取元素的位置
     * @return
     */
    E get(int index);

    /***
     * 设置index位置的元素
     * @param index 设置元素的位置
     * @param element 设置的元素
     * @return 原来的元素
     */
    E set(int index, E element);

    /***
     * 在index位置插入一个元素
     * @param index 插入的元素位置
     * @param element 插入的元素
     */
    void add(int index, E element);

    /***
     * 删除index位置的元素
     * @param index 删除的元素
     * @return 删除的元素
     */
    E remove(int index);

    /***
     * 查看元素的索引
     * @param element 查找的元素
     * @return 元素的索引
     */
    int indexOf(E element);
}
