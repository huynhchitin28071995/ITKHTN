package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

	public List<Integer> preOrderTraversal(BinaryTreeNode root) {

		List<Integer> a = new ArrayList<>();
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

	public void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.getData());
			inOrder(root.right);
		}
	}

	public List<Integer> inOrderTraversal(BinaryTreeNode root) { // until s is empty, check all left then check right.
		List<Integer> a = new ArrayList<>();
		BinaryTreeNode currentNode = root;
		boolean done = false;
		Stack<BinaryTreeNode> s = new Stack<>();
		while (true) { // tendency to check all left leaves of each node.
			if (currentNode != null) { // go all the way to the left leaf. check all left leaves until null.
				s.push(currentNode); // push all left leaves
				currentNode = currentNode.left;
			} else {
				if (s.isEmpty())
//					done = true;
					break;
				else {
					currentNode = s.pop();
					a.add(currentNode.getData());
					currentNode = currentNode.right; // check each left leaf's sibling(right leaf of the same father),
														// enter the loop again, check all left leaves of the right
														// leaf.
				}
			}
		}
		return a;
	}

	// not good enough. can't check all left children of each node.
	public List<Integer> inOrderTraversal_1(BinaryTreeNode root) { // tendency to check all children nodes of each node.
		List<Integer> a = new ArrayList<>();
		BinaryTreeNode currentNode = root;
		Stack<BinaryTreeNode> s = new Stack<>();
		while (currentNode != null) { // push all left leaves
			s.push(currentNode);
			currentNode = currentNode.left;
		}
		while (!s.isEmpty()) {
			currentNode = s.pop();
			a.add(currentNode.getData());
			if (currentNode.right != null) { // check the right node of the popped node.
				currentNode = currentNode.right; // currentNode has been altered here.
				s.push(currentNode); // push the right node for the next pop operation and check it's left and right
										// node again.
			}
			if (currentNode.left != null) { // check left node of the popped node. just in case the right node have a
											// left child node.
				currentNode = currentNode.left; // it's the left child of the right node.
				s.push(currentNode); // the stack is pushed twice if the right node have a left child.
			}
		}
		return a;
	}

	public void postOrder(BinaryTreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}

	public List<Integer> postOrderTraversal(BinaryTreeNode root) {
		List<Integer> l = new LinkedList<Integer>();
		if (root == null)
			return l;
		BinaryTreeNode cur;
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			cur = s.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null)
					s.push(cur.left);
				else if (cur.right != null)
					s.push(cur.right);
			} else if (cur.left == prev) {
				if (cur.right != null)
					s.push(cur.right);
			} else {
				l.add(cur.data);
				s.pop();
			}
			prev = cur;
		}
		return l;
	}

	public List<List<Integer>> levelOrder(BinaryTreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		// Initialization
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		List<Integer> curr = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.left != null)
					q.offer(tmp.left);
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				List<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear(); // Java will clear the reference, so have to new an ArrayList.
				// completion of a level when q.poll=null
				if (!q.isEmpty())
					q.offer(null);// to mark a new level(n+1)
			}
		}
		return res;
	}
}
