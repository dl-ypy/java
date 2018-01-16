/**
 * date:2017年6月28日09:18:33
 * target:实现二叉树
 * @author ypy
 */
public class BinaryTree {
	public static void main(String[] args) {
		int[] data = new int[20];
		for (int i=0; i<data.length; i++) {
			data[i] = (int)(Math.random()*100) + 1;
			System.out.println(data[i] + ",");
		}
		System.out.println();
		
		Node root = new Node();
		root.value = data[0];
		for (int i=1; i<data.length; i++) {
			root.store(data[i]);
		}
		root.find(data[19]);
		System.out.println("*************************");
		System.out.println("先序遍历：");
		root.preList();
		System.out.println("*************************");
		System.out.println("中序遍历：");
		root.middleList();
		System.out.println("*************************");
		System.out.println("后序遍历：");
		root.afterList();
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	//进行存储
	public void store(int value) {
		if (value < this.value) {
			if (left == null) {
				left = new Node();
				left.value = value;
			} else {
				left.store(value);
			} 
		} else if (value > this.value) {
			if (right == null) {
				right = new Node();
				right.value = value;
			} else {
				right.store(value);
			}
		}
	}
	
	public boolean find(int value) {
		System.out.println("happen:" + this.value);
		if (value == this.value) {
			return true;
		} else if (value > this.value) {
			if (right == null) {
				return false;
			}
			return right.find(value);
		} else {
			if (left == null) {
				return false;
			}
			return left.find(value);
		}
	}
	
	//先序遍历
	//首先访问根，再先序遍历左（右）子树，最后先序遍历右（左）子树
	public void preList() {
		System.out.println(this.value + ",");
		if (left != null) {
			left.preList();
		}
		if (right != null) {
			right.preList();
		}
	}
	
	//中序遍历
	//首先中序遍历左（右）子树，再访问根，最后中序遍历右（左）子树
	public void middleList() {
		if (left != null) {
			left.preList();
		}
		System.out.println(this.value + ",");
		if (right != null) {
			right.preList();
		}
	}
	
	//后序遍历
	//首先后序遍历左（右）子树，再后序遍历右（左）子树，最后访问根
	public void afterList() {
		if (left != null) {
			left.preList();
		}
		if (right != null) {
			right.preList();
		}
		System.out.println(this.value + ",");
	}
}
/*
***************JDK1.8运行结果****************
24,
41,
59,
86,
28,
36,
78,
27,
62,
24,
43,
74,
79,
67,
57,
15,
35,
85,
36,
36,

happen:24
happen:41
happen:28
happen:36
*************************
先序遍历：
24,
15,
41,
28,
27,
36,
35,
59,
43,
57,
86,
78,
62,
74,
67,
79,
85,
*************************
中序遍历：
15,
24,
41,
28,
27,
36,
35,
59,
43,
57,
86,
78,
62,
74,
67,
79,
85,
*************************
后序遍历：
15,
41,
28,
27,
36,
35,
59,
43,
57,
86,
78,
62,
74,
67,
79,
85,
24,
*/
