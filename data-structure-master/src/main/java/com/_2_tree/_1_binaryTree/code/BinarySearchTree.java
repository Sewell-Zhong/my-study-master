package com._2_tree._1_binaryTree.code;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 * @author : Mr-Z
 * @date : 2020/10/19 23:22
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    /**
     * 节点数量
     */
    private int size;
    /**
     * 根节点
     */
    private Node<E> root;

    /**
     * 比较器
     */
    private Comparator<E> comparator;

    /**
     * 获取根节点
     * @return
     */
    @Override
    public Object root() {
        return root;
    }

    /**
     * 获取节点的左节点
     * @param node 要获取的节点
     * @return
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    /**
     * 获取节点的右节点
     * @param node 要获取的节点
     * @return
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    /**
     * 返回节点的值
     * @param node 节点
     * @return
     */
    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }


    public BinarySearchTree() {
        this(null);
    }
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 返回节点的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空
     */
    public void clear() {

    }

    /**
     * 添加节点
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            //添加的第一个节点
            root = new Node<>(element,null);
            size++;
            return;
        }

        //添加的不是第一个节点
        //找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element,node.element);
            parent = node;
            if (cmp > 0) {
                //右节点
                node = node.right;
            } else if (cmp < 0) {
                //左节点
                node = node.left;
            } else  {
                //相等，传进来的值，覆盖原来的值
                node.element = element;
                return;
            }
        }
        //看看插入到父节点的那个位置
        Node<E> newNode = new Node(element,parent);
        if (cmp > 0) {
            //右边
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 移除节点
     * @param element
     */
    public void remove(E element) {

    }

    /**
     * 判断节点是否存在
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return false;
    }

    /**
     * 前序遍历
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    /**
     * 前序遍历（递归）
     * @param node
     */
    private void  preorderTraversal(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(){
        inorderTraversal(root);
    }

    /**
     * 中序遍历（递归）
     * @param node
     */
    private void inorderTraversal(Node<E> node) {
        if (node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    /**
     * 后序遍历（递归）
     * @param node
     */
    private void postorderTraversal(Node<E> node) {
        if (node == null){
            return;
        }
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历
     */
    public void levelorderTraversal() {
        if (root == null){
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void preOrder(Visitor<E> visitor) {}

    private void preOrder(Node<E> node , Visitor<E> visitor) {
        if (node == null || visitor == null){
            return;
        }
        visitor.visit(node.element);
        preOrder(node.left,visitor);
        preOrder(node.right,visitor);
    }

    public void inOrder(Visitor<E> visitor) {}
    private void inOrder(Node<E> node , Visitor<E> visitor) {
        if (node == null || visitor == null){
            return;
        }
        preOrder(node.left,visitor);
        visitor.visit(node.element);
        preOrder(node.right,visitor);
    }

    public void postOrder(Visitor<E> visitor) {}
    private void postOrder(Node<E> node ,Visitor<E> visitor) {
        if (node == null || visitor == null){
            return;
        }
        preOrder(node.left,visitor);
        visitor.visit(node.element);
        preOrder(node.right,visitor);
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null){
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 访问器接口
     * @param <E>
     */
    public static  interface Visitor<E> {
        void visit(E element);
    }

    /**
     * 检查是否为空
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root,sb,"");
        return sb.toString();
    }

    private void toString(Node<E> node ,StringBuilder sb, String prefix) {
        if (node == null) {
            return;
        }
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left,sb,prefix + "L - - -");
        toString(node.right,sb,prefix + "R - - -");
    }

    public int height() {
        return height(root);
    }

    /**
     * 计算节点高度
     * @param node
     * @return
     */
    private int height(Node<E> node) {
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left),height(node.right));
    }

    /**
     * 计算节点高度（层序遍历实现）
     */
    public int height1() {
        if (root == null){
            return 0;
        }
        int height = 0;//树的高度
        int levelSize = 1;//存储着每一层元素的数量
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                //即将访问下一层
                levelSize = queue.size();
                height++;
            }
        }
        return height(root);
    }


    /**
     * 是否完全二叉树
     * @return
     */
    public boolean isComplete() {
        if (root == null){
            return false;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()){
                return false;
            }
            if (node.hasTwoChildren()) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {
                //意味着后遍历的节点，都必须是叶子节点
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 比较两个节点大小
     * @param e1
     * @param e2
     * @return 返回值等于0，代表e1和e2相等，返回值大于0，代表e1大于e2，返回值小于0,代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
          return   comparator.compare(e1,e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * 前驱节点
     * @param node
     * @return
     */
    private Node<E> predecessor(Node<E> node) {
        if (node == null){
            return null;
        }
        Node<E> p = node.left;
        if (p != null) {
            //从左子树中找前驱
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        //从父节点，祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        //node.parent == null
        //node == node.parent.right
        return node.parent;
    }

    /**
     * 后继节点
     * @param node
     * @return
     */
    private Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p = node.right;
        if (p != null) {
            //从右子树中找前驱
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //从父节点，祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        //node.parent == null
        //node == node.parent.right
        return node.parent;
    }

    /**
     * 节点类
     * @param <E>
     */
    private static class Node<E> {
        /**
         * 节点的值
         */
        E element;
        /*
        * 左节点
        * */
        Node<E> left;
        /*
        * 右节点
        * */
        Node<E> right;
        /*
        * 父节点
        * */
        Node<E> parent;

        public Node(E element,Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        /**
         * 是否叶子节点
         * @return
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * 是否有左右子节点
         * @return
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }
}
