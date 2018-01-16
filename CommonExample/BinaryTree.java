/**
 * date:2017��6��28��09:18:33
 * target:ʵ�ֶ�����
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
		System.out.println("���������");
		root.preList();
		System.out.println("*************************");
		System.out.println("���������");
		root.middleList();
		System.out.println("*************************");
		System.out.println("���������");
		root.afterList();
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	//���д洢
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
	
	//�������
	//���ȷ��ʸ���������������ң������������������ң�������
	public void preList() {
		System.out.println(this.value + ",");
		if (left != null) {
			left.preList();
		}
		if (right != null) {
			right.preList();
		}
	}
	
	//�������
	//��������������ң��������ٷ��ʸ��������������ң�������
	public void middleList() {
		if (left != null) {
			left.preList();
		}
		System.out.println(this.value + ",");
		if (right != null) {
			right.preList();
		}
	}
	
	//�������
	//���Ⱥ���������ң��������ٺ�������ң��������������ʸ�
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
***************JDK1.8���н��****************
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
���������
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
���������
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
���������
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
