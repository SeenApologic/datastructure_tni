public class TestLinkedNode {
	public static void main(String[] args) {
		 Node node1 = new Node("Alice");
		 System.out.print("node1 created! ");
		 System.out.println("Address = " + Node.getAddress(node1));
		 System.out.println("Data = " + node1.data);
		 System.out.println("Pointer address = " + Node.getAddress(node1.next));
		 
		 Node node2 = new Node(25);
		 System.out.print("\nnode2 created! ");
		 System.out.println("Address = " + Node.getAddress(node2));
		 System.out.println("Data = " + node2.data);
		 System.out.println("Pointer address = " + Node.getAddress(node2.next));
		 
		 Node node3 = new Node(true);
		 System.out.print("\nnode3 created! ");
		 System.out.println("Address = " + Node.getAddress(node3));
		 System.out.println("Data = " + node3.data);
		 System.out.println("Pointer address = " + Node.getAddress(node3.next));
		 
		 Node node4 = new Node(17.5);
		 System.out.print("\nnode4 created! ");
		 System.out.println("Address = " + Node.getAddress(node4));
		 System.out.println("Data = " + node4.data);
		 System.out.println("Pointer address = " + Node.getAddress(node4.next));
		 
		 // เชื่อมทุก node เข้าด้วยกันตามตาราง: node1 -> node2 -> node3 -> node4
		 node1.next = node2;
		 node2.next = node3;
		 node3.next = node4;
		 
		 // แสดงผล Data, Address และ Pointer Address ของแต่ละ node หลังจากเชื่อมกันแล้ว
		 System.out.println("\n--- After linking all nodes ---");
		 
		 System.out.println("\nnode1: Data = " + node1.data 
				 + ", Address = " + Node.getAddress(node1) 
				 + ", Pointer address = " + Node.getAddress(node1.next));
		 
		 System.out.println("node2: Data = " + node2.data 
				 + ", Address = " + Node.getAddress(node2) 
				 + ", Pointer address = " + Node.getAddress(node2.next));
		 
		 System.out.println("node3: Data = " + node3.data 
				 + ", Address = " + Node.getAddress(node3) 
				 + ", Pointer address = " + Node.getAddress(node3.next));
		 
		 System.out.println("node4: Data = " + node4.data 
				 + ", Address = " + Node.getAddress(node4) 
				 + ", Pointer address = " + Node.getAddress(node4.next));
	}
}