package graph;

import java.util.ArrayList;

import linkedList.LinkedList;
import linkedList.ListNode;

public class ListGraph implements Graph {
	private ArrayList<Integer> vertices;
	private LinkedList[] edges;
	private int vertexCount = 0;

	public ListGraph(int vertexCount) {
		this.vertexCount = vertexCount;
		vertices = new ArrayList<>();
		edges = new LinkedList[this.vertexCount];
		for (int i = 0; i < this.vertexCount; i++) {
			vertices.add(i);
			edges[i] = new LinkedList();
		}
	}

	public void addEdge(int source, int destination) {
		int i = vertices.indexOf(source);
		int j = vertices.indexOf(destination);
		if (i != -1 || j != -1) {
			edges[i].insertAtBegin(new ListNode(destination));
			edges[j].insertAtBegin(new ListNode(source));
		}
	}
}
