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
	}

	public ThreadedBinaryTreeNode getRight() {
		return right;
	}

	public void setRight(ThreadedBinaryTreeNode right) {
		this.right = right;
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

}
