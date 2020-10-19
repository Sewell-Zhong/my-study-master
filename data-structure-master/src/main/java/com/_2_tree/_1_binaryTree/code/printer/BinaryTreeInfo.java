package com._2_tree._1_binaryTree.code.printer;

/**
 * 二叉树接口
 * @author : Mr-Z
 * @date : 2020/10/19 23:16
 */
public interface BinaryTreeInfo {
	/**
	 * 获取根节点
	 * @return
	 */
	Object root();
	/**
	 * 获取节点的左节点
	 * @param node 要获取的节点
	 * @return
	 */
	Object left(Object node);
	/**
	 * 获取节点的右节点
	 * @param node 要获取的节点
	 * @return
	 */
	Object right(Object node);
	/**
	 * 返回节点的值
	 * @param node 节点
	 * @return
	 */
	Object string(Object node);
}
