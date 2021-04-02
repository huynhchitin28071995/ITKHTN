package tree;

public class Problems1_5 {
	private static int problem1(BinaryTreeNode root) {
		int max = Integer.MIN_VALUE;
		if (root != null) {
			int maxLeft = problem1(root.left);
			int maxRight = problem1(root.right);
			if (maxLeft > maxRight)
				max = maxLeft;
			else
				max = maxRight;
			if (root.data > max)
				max = root.data;
		}
		return max;
	}

	public static void main(String[] args) {
		BinaryTreeNode b = new BinaryTreeNode(1);
		b.setLeft(new BinaryTreeNode(2));
		b.setRight(new BinaryTreeNode(3));
		b.getLeft().setLeft(new BinaryTreeNode(4));
		b.getLeft().setRight(new BinaryTreeNode(5));
		b.getRight().setLeft(new BinaryTreeNode(6));
		b.getRight().setRight(new BinaryTreeNode(7));
		System.out.println(problem1(b));
	}
}
