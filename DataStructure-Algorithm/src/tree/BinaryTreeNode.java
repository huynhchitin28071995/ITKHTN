package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left, right;

	public BinaryTreeNode(int data) {
		left = right = null;
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public void preOrder(BinaryTreeNode root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {

		ArrayList<Integer> a = new ArrayList<>();
		if (root == null)
			return a;
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			BinaryTreeNode temp = s.pop();
			a.add(temp.data);
			if (temp.right != null)
				s.push(temp.right);
			if (temp.left != null)
				s.push(temp.left);
		}
		return a;
	}
}
