package tree;

public class Test {

	public static void main(String[] args) {
		BinaryTreeNode b = new BinaryTreeNode(1);
		b.setLeft(new BinaryTreeNode(2));
		b.setRight(new BinaryTreeNode(3));
		b.getLeft().setLeft(new BinaryTreeNode(4));
		b.getLeft().setRight(new BinaryTreeNode(5));
		b.getRight().setLeft(new BinaryTreeNode(6));
		b.getRight().setRight(new BinaryTreeNode(7));
		b.getRight().getLeft().setLeft(new BinaryTreeNode(8));
		b.preOrder(b);
		System.out.println(b.preOrderTraversal(b));
		b.inOrder(b);
		System.out.println(b.inOrderTraversal(b));
		System.out.println(b.inOrderTraversal_1(b));
	}
}
