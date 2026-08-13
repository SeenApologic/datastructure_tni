class Node {
	public int  data;
	public Node next;
	
	public Node(int value) {
		this.data = value;
		this.next = null;
	}
}

public class SinglyLinkedList {
	private Node head;
	private Node tail;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	
	public String displayList() {
		boolean first = true;
		String  display = "[";
		for (Node current = head; current != null; current = current.next) {
			display += (!first ? ", " : "") + current.data;
			first = false;
		}
		display += "]";
		return display;
	}
	
	public void clear() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null ;
	}
	
	public void append(int value) {
		Node new_node = new Node(value);
		
		if(head == null) {
			head = new_node;
			tail = new_node;
		}else {
			tail.next = new_node;
			tail = new_node;
		}
	}
	
	public Object get(int position) {
		Node current = head;
		int current_position = 0;
		
		while(current != null && current_position < position) {
			current = current.next;
			current_position++;
		}
		if(current != null) {
			return current.next;
		}else {
			return null;
		}
	}
	
	public void set(int position, int value) {
		Node current = head;
		int current_position = 0;
		
		while(current != null && current_position < position) {
			current = current.next;
			current_position++;
		}
		
		if(current != null) {
			current.data = value;
			System.out.println("Updated data success!!");
		}else {
			System.out.println("Updated data fail…");
		}
	}
	
	public boolean contains(int value) {
		for(Node current = head; current != null; current = current.next) {
			if(current.data == value)
				return true;
		}
		return false;
	}
	
	public void addAll(SinglyLinkedList otherlist) {
		for(Node current = otherlist.head; current != null; current = current.next) {
			this.append(current.data);
		}
	}
	
}
