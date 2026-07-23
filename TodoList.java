
public class TodoList {
	public static void main(String[] args) {
		DoublyLinkedList todolist = new DoublyLinkedList();

		todolist.insert("Finish Homework");
		todolist.insert("Laungry");
		todolist.insert("Group Meeting");
		System.out.println(todolist.traversal());
		
		todolist.insert(0,"Submit Report");
		System.out.println(todolist.traversal());
		
		todolist.insert(2, "Buy Food");
		System.out.println(todolist.traversal());
		
		todolist.insert("Go to Gym");
		System.out.println(todolist.traversal());
	}
	
}
