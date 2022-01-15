package lists;

import java.util.ArrayList;

public class LinkedList {

	Node head;
	Node tail;
	ArrayList<Node> list;

	LinkedList() {
		this.head = null;
		this.tail = null;
		this.list = new ArrayList<Node>();
	}

	Node getFirst() {
		return head;
	}

	Node getLast() {
		return tail;
	}

	Node get(int index) {
		Node node = head;
		for (int i = 1; i < index; i++) {
			node = node.getNxtNode();
		}
		return node;
	}

	void addFirst(int dataField) {
		Node newNode = new Node(dataField, null, this.head);
		head.setPrvNode(newNode);
		list.add(newNode);
	}

	void addLast(int dataField) {
		Node newNode = new Node(dataField, this.tail, null);
		tail.setNxtNode(newNode);
		list.add(newNode);
	}

	void insert(int dataField, int index) {
		Node currentNode = get(index);
		Node previousNode = currentNode.getPrvNode();
		Node insertionNode = new Node(dataField, previousNode, currentNode);
		//  Adds links to the new node
		previousNode.setNxtNode(insertionNode);
		currentNode.setPrvNode(insertionNode);
	}

	void removeFirst() {
		list.remove(head);
	}

	void removeLast() {
		list.remove(tail);
	}
	
	void remove(int index) {
		Node currentNode = get(index);
		Node previousNode = currentNode.getPrvNode();
		Node nextNode = currentNode.getNxtNode();
		// Redirects links, bypassing middle node
		previousNode.setNxtNode(nextNode);
		nextNode.setPrvNode(previousNode);
	}
	
	int size() {
		return list.size();
	}
	
	boolean isEmpty() {
		return list.size() == 0;
	}

	public String toString() {
		String string = "";
		for (Node n : this.list) {
			string += n.toString();
		}
		return string;
	}

}
