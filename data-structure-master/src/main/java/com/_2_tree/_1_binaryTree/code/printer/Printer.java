package com._2_tree._1_binaryTree.code.printer;

/**
 * 打印信息类
 * @author : Mr-Z
 * @date : 2020/10/19 23:21
 */
public abstract class Printer {	
    /**
     * 二叉树的基本信息
     */
	protected BinaryTreeInfo tree;
	
	public Printer(BinaryTreeInfo tree) {
		this.tree = tree;
	}
	
	/**
	 * 生成打印的字符串
	 */
	public abstract String printString();
	
	/**
	 * 打印后换行
	 */
	public void println() {
		print();
		System.out.println();
	}
	
	/**
	 * 打印
	 */
	public void print() {
		System.out.print(printString());
	}
}
