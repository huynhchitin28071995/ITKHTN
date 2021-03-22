package linkedList;

public interface Node {
	public int getData();
	public void setData(int data);
	public Node getPrev();
	public void setPrev(Node prev);
	public Node getNext();
	public void setNext(Node next);
}
