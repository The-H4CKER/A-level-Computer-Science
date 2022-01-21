package lists;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinkedList {
	Node head;
	Node tail;

	LinkedList(int... dataValues) {
		for (int dataValue : dataValues) 
			InsertNode(new Node(dataValue, null, null));
	}

	boolean IsEmpty() {
		return GetHead() == null;
	}

	Node GetHead() {
		return head;
	}

	Node GetTail() {
		return tail;
	}

	void SetHead(Node newHead) {
		head = newHead;
	}

	void SetTail(Node newTail) {
		tail = newTail;
	}

	ArrayList<Integer> GetLinkedList() {
		ArrayList<Integer> orderedList = new ArrayList<Integer>();
		for (Node currentNode = head; currentNode != null; currentNode = currentNode.GetNxtNode())
			orderedList.add(Integer.valueOf(currentNode.GetDataField()));
		return orderedList;
	}

	int Length() {
		return GetLinkedList().size();
	}

	void AddNode(Node node, Node prvNode, Node nxtNode) {
		node.SetNxtNode(nxtNode);
		node.SetPrvNode(prvNode);

		if (prvNode == null)
			SetHead(node);
		else
			prvNode.SetNxtNode(node);
		if (nxtNode == null)
			SetTail(node);
		else
			nxtNode.SetPrvNode(node);
	}

	Node GetNodeAt(int posInLinkedList) {
		Node currentNode = head;
		int indexPos = 0;
		while (currentNode != null && indexPos != posInLinkedList) {
			currentNode = currentNode.GetNxtNode();
			indexPos++;
		}
		return currentNode;
	}

	void InsertNode(Node newNode, int posNxtNode) {
		posNxtNode = Math.min(posNxtNode, Length());
		AddNode(newNode, GetNodeAt(posNxtNode - 1), GetNodeAt(posNxtNode));
	}

	void InsertNode(Node newNode) {
		InsertNode(newNode, Length());
	}

	Node removeAtPosition(int posInLinkedList) {
		Node deadNode = GetNodeAt(posInLinkedList);
		Node prvNode = deadNode.GetPrvNode();
		Node nxtNode = deadNode.GetNxtNode();

		if (prvNode == null)
			SetHead(deadNode);
		else
			prvNode.SetNxtNode(deadNode);
		if (nxtNode == null)
			SetTail(deadNode);
		else
			nxtNode.SetPrvNode(deadNode);

		return deadNode;
	}

	public String toString() {
		return "[" + GetLinkedList().stream().map(Object::toString).collect(Collectors.joining(", ")) + "]";
	}
}
