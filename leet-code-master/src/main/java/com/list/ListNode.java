package com.list;

/**
 * 链表节点类
 * @author : Mr-Z
 * @date : 2020/11/16 21:39
 */
public class ListNode {

    int    val;

    ListNode next;

    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    /**
     * 初始化
     * @return
     */
    public static ListNode init(int[] arr) {
        ListNode head = null;
        ListNode cur = null;
        for (int i : arr) {
            ListNode node =new ListNode(i);
            if(i==1){
                head = node;
            }else{
                cur.next = node;
            }
            cur=node;
        }
        return head;
    }
}
