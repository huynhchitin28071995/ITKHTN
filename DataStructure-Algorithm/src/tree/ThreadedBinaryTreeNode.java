package tree;

public class ThreadedBinaryTreeNode {
	private ThreadedBinaryTreeNode left, right;
	private int lTag;
	private int data;
	private int rTag;

	public ThreadedBinaryTreeNode inorderSuccessor(ThreadedBinaryTreeNode p) {
		ThreadedBinaryTreeNode pos;
		if (p.rTag == 0)
			return p.right;
		else {
			pos = p.right;
			while (pos.lTag == 1)
				pos = pos.left;
			return pos;
		}
	}

	public ThreadedBinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(ThreadedBinaryTreeNode left) {
		this.left = left;
		lTag = 1;
	}

	public ThreadedBinaryTreeNode getRight() {
		return right;
	}

	public void setRight(ThreadedBinaryTreeNode right) {
		this.right = right;
		rTag = 1;
	}

	public int getlTag() {
		return lTag;
	}

	public void setlTag(int lTag) {
		this.lTag = lTag;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getrTag() {
		return rTag;
	}

	public void setrTag(int rTag) {
		this.rTag = rTag;
	}

	public void inorderTraversal(ThreadedBinaryTreeNode root) {
		if (root == null)
			return;
		ThreadedBinaryTreeNode p = inorderSuccessor(root);
		while (p != root) {
			p = inorderSuccessor(p);
			System.out.println(p.getData());
		}
	}

	public ThreadedBinaryTreeNode(int data) {
		if (left == null) {
			lTag = 0;
		}
		if (right == null)
			rTag = 0;
		this.data = data;
	}

	public ThreadedBinaryTreeNode() {
		if (left == null) {
			lTag = 0;
		}
		if (right == null)
			rTag = 0;
	}

	public ThreadedBinaryTreeNode preOderSuccessor(ThreadedBinaryTreeNode node) {
		ThreadedBinaryTreeNode p = node;
		if (p.lTag == 1)
			return p.getLeft();

		else {
			while (p.rTag == 0)
				p = p.getRight();
			return p.getRight();
		}

	}

	public static void main(String[] args) {
		ThreadedBinaryTreeNode dummy = new ThreadedBinaryTreeNode(-1);
		ThreadedBinaryTreeNode root = new ThreadedBinaryTreeNode();
		dummy.setLeft(root);
		root.setData(1);
		root.setLeft(new ThreadedBinaryTreeNode(2));
		root.setRight(new ThreadedBinaryTreeNode(3));
		root.getLeft().setLeft(new ThreadedBinaryTreeNode(4));
		root.getLeft().setRight(new ThreadedBinaryTreeNode(5));
		root.getRight().setLeft(new ThreadedBinaryTreeNode(6));
		root.getRight().setRight(new ThreadedBinaryTreeNode(7));
		root.getRight().getRight().setRight(dummy);
		root.getRight().getRight().setrTag(0);
		root.getLeft().getLeft().setLeft(dummy);
		root.getLeft().getLeft().setlTag(0);
		dummy.inorderTraversal(root);
	}

}
