package lists;

public class Main {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.InsertNode(new Node(5));
		list.InsertNode(new Node(1));
		list.InsertNode(new Node(3));
		System.out.println(list);
		list.removeAtPosition(0);
		System.out.println(list);
		list.InsertNode(new Node(7));
		list.InsertNode(new Node(2));
		System.out.println(list);
		list.InsertNode(new Node(9), 2);
		System.out.println(list);
		list.removeAtPosition(2);
		System.out.println(list);
		list.InsertNode(new Node(19), 2);
		System.out.println(list);
		list.InsertNode(new Node(29), 0);
		System.out.println(list);
		list.InsertNode(new Node(99));
		System.out.println(list);
	}
}
