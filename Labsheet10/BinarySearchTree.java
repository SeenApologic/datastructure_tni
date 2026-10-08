
public class BinarySearchTree {

	private Node root;
	private Node parent;
	private Node deleteNode;

	public boolean isEmpty() {
		return root == null;
	}
	
	public void sampleTree1() {
		int[] nums = {20,10,60,7,11,30,65,3,40};
		
		for (int num : nums) {
			insert(num);
		}
	}
	
	public void printTree(Node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node getDeleteNode() {
		return deleteNode;
	}
	
	public void insert(int new_data) {
		if (root == null) {
			root = new Node(new_data);
		} else {
			Node current_node = root;
			while (true) {
				if (new_data < current_node.data) {
					if (current_node.left == null) {
						current_node.left = new Node(new_data);
						break;
					}
					current_node = current_node.left;
				}
				else if (new_data > current_node.data) {
					if (current_node.right == null) {
						current_node.right = new Node(new_data);
						break;
					}
					current_node = current_node.right; 
				}
				
			} //end while
		} //end if
	}
	
	// ข้อ 1) คืนค่า Node ที่มีค่าน้อยที่สุดใน BST (เดินไปทางซ้ายสุด)
	public Node findMinimum() {
		return findMinimum(root);
	}
	
	// หาค่าน้อยที่สุดของ subtree ที่เริ่มจาก start_node
	public Node findMinimum(Node start_node) {
		if (start_node == null) {
			return null;
		}
		Node current_node = start_node;
		while (current_node.left != null) {
			current_node = current_node.left;
		}
		return current_node;
	}
	
	// ข้อ 2) คืนค่า Node ที่มีค่ามากที่สุดใน BST (เดินไปทางขวาสุด)
	public Node findMaximum() {
		return findMaximum(root);
	}
	
	// หาค่ามากที่สุดของ subtree ที่เริ่มจาก start_node
	public Node findMaximum(Node start_node) {
		if (start_node == null) {
			return null;
		}
		Node current_node = start_node;
		while (current_node.right != null) {
			current_node = current_node.right;
		}
		return current_node;
	}
	
	// ข้อ 4) ค้นหา Node ที่มีข้อมูลตาม target: เจอคืน true ไม่เจอคืน false
	public boolean findSpecificData(int target) {
		Node current_node = root;
		while (current_node != null) {
			if (target == current_node.data) {
				return true;
			}
			if (target < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}
		return false;
	}
	
	// ข้อ 6) ค้นหา Node ที่จะลบ พร้อมกำหนดค่าให้ parent และ deleteNode
	public void searchDeleteNode(int target) {
		parent = root;
		deleteNode = null;   // ล้างค่าเก่า เผื่อค้นไม่เจอจะไม่ค้างค่าจากครั้งก่อน
		Node current_node = root;
		while (current_node != null) {
			if (current_node.data == target) {
				deleteNode = current_node;
				break;
			}
			parent = current_node;
			if (target < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}
	}
	
	// ข้อ 8) ลบ Node ตามข้อมูล target รองรับทุกกรณี
	public void delete(int target) {
		searchDeleteNode(target);
		
		if (deleteNode == null) {
			return;   // ไม่พบข้อมูลใน BST ไม่มีอะไรให้ลบ
		}
		
		if (deleteNode.left == null && deleteNode.right == null) {
			deleteLeafNode();                 // กรณีที่ 1: Leaf Node
		} else if (deleteNode.left != null && deleteNode.right != null) {
			deleteReplaceMaxLeft();           // กรณีที่ 3: มี 2 Subtree (ใช้วิธี max ของ Left)
			// deleteReplaceMinRight();       // หรือเปลี่ยนเป็นวิธี min ของ Right
		} else {
			deleteOneSubtreeNode();           // กรณีที่ 2: มี 1 Subtree
		}
	}
	
	// เปลี่ยนตัวชี้ที่ชี้มาหา old_child (จาก parent หรือ root) ให้ไปชี้ new_child แทน
	private void replaceChild(Node old_child, Node new_child) {
		if (old_child == root) {
			root = new_child;
		} else if (parent.left == old_child) {
			parent.left = new_child;
		} else {
			parent.right = new_child;
		}
	}
	
	// กรณีที่ 1: ลบ Leaf Node -> ให้ parent ชี้เป็น null
	private void deleteLeafNode() {
		replaceChild(deleteNode, null);
	}
	
	// กรณีที่ 2: ลบ Node ที่มี 1 Subtree -> ให้ parent ข้ามไปชี้ลูกของ Node ที่ลบแทน
	private void deleteOneSubtreeNode() {
		Node child = (deleteNode.left != null) ? deleteNode.left : deleteNode.right;
		replaceChild(deleteNode, child);
	}
	
	// กรณีที่ 3 (วิธี 1): Replace by the maximum in Left subtree
	private void deleteReplaceMaxLeft() {
		Node max_parent = deleteNode;
		Node max_node = deleteNode.left;
		while (max_node.right != null) {
			max_parent = max_node;
			max_node = max_node.right;
		}
		deleteNode.data = max_node.data;   // เอาค่ามากสุดของ Left มาแทน
		
		// ตัด max_node ออก โดยให้ลูกซ้ายของมัน (ถ้ามี) มาแทนที่
		if (max_parent == deleteNode) {
			max_parent.left = max_node.left;
		} else {
			max_parent.right = max_node.left;
		}
	}
	
	// กรณีที่ 3 (วิธี 2): Replace by the minimum in Right subtree
	private void deleteReplaceMinRight() {
		Node min_parent = deleteNode;
		Node min_node = deleteNode.right;
		while (min_node.left != null) {
			min_parent = min_node;
			min_node = min_node.left;
		}
		deleteNode.data = min_node.data;   // เอาค่าน้อยสุดของ Right มาแทน
		
		// ตัด min_node ออก โดยให้ลูกขวาของมัน (ถ้ามี) มาแทนที่
		if (min_parent == deleteNode) {
			min_parent.right = min_node.right;
		} else {
			min_parent.left = min_node.right;
		}
	}
	
}
