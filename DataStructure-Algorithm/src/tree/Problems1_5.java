package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problems1_5 {
	private static int problem1(BinaryTreeNode root) { // find max in tree with recursion
		int max = Integer.MIN_VALUE;
		if (root != null) {
			int maxLeft = problem1(root.left);
			int maxRight = problem1(root.right);
			if (maxLeft > maxRight)
				max = maxLeft;
			else
				max = maxRight;
			if (root.getData() > max)
				max = root.getData();
		}
		return max;
	}
	
	private static void problem2(BinaryTreeNode root) { //find max in tree without recursion 
		if(root == null ) return;
		int max = Integer.MIN_VALUE;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode cur = s.pop();
			if(max<cur.getData()) max = cur.getData();
			if(cur!=null) {
			if(cur.right!=null)s.push(cur.right);
			if(cur.left!=null)s.push(cur.getLeft());
		}}
		System.out.println(max);
	}
	
	private static void problem2a(BinaryTreeNode root) { //this is level order traversal
		if(root == null ) return;
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode cur = q.poll();
			if(max<cur.getData()) max = cur.getData();
			System.out.println(cur.getData());
			if(cur.left!=null) q.offer(cur.left);
			if(cur.right!=null)q.offer(cur.right);
		}
		System.out.println("Max is: " + max);
	}
	
	private static void problem4(BinaryTreeNode root, BinaryTreeNode e) { //search an element in tree without recursion
		//use in order traversal to traverse
		Stack<BinaryTreeNode> s = new Stack<>();
		List<BinaryTreeNode> l = new LinkedList<>();
		BinaryTreeNode cur = root;
		while(true) {
			if(cur!=null) {
				s.push(cur);
				cur=cur.left;
			} else {
				if(s.isEmpty()) {
					break;
				} else {
					cur = s.pop();
					l.add(cur);
//					if(cur.right!= null) // this will make cur always not null
						cur = cur.right;
				}
			}
		}
		System.out.println(l.toString());
		System.out.println(l.contains(e));
	}
	
	private static boolean problem3(BinaryTreeNode root, BinaryTreeNode e) { //search element in tree with recursion
		if(root==null) {
			return false;
		}
		if(root.equals(e)) {
			System.out.println(root.getData());
			return true;
		} 
		
		return problem3(root.left, e)||problem3(root.right,e);
	}

	private static void problem5(BinaryTreeNode root, BinaryTreeNode addedE) { //insert an element. Using level order traversal.
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode b = new BinaryTreeNode(1);
		b.setLeft(new BinaryTreeNode(2));
		b.setRight(new BinaryTreeNode(3));
		b.getLeft().setLeft(new BinaryTreeNode(4));
		b.getLeft().setRight(new BinaryTreeNode(5));
		b.getRight().setLeft(new BinaryTreeNode(6));
		b.getRight().setRight(new BinaryTreeNode(7));
//		System.out.println(problem1(b));
//		problem2(b);
//		problem2a(b);
//		problem4(b, b.getLeft().getRight());
		System.out.println(problem3(b, b.getLeft().getRight()));
		System.out.println(problem3(b, new BinaryTreeNode(10)));
	}
}
