import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

	private node root;
	private node parent;
	private node deleteNode;

	public BinaryTree() {
		root = null;
	}
	
	public node getRoot() {
		return root;
	}
	
	public node getParent() {
		return parent;
		}
	public node getDeleteNode() {
		return deleteNode;
		}

	public void printTree(node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}
	
	public void createTree1() {
		root = new node(1);
		root.left = new node(2);
		root.right = new node(3);
		root.left.left = new node(4);
		root.left.right = new node(5);
		root.right.left = new node(6);
		root.right.right = new node(7);
	}
	
	public void createTree2() {
		root = new node(15);
		root.left = new node(8);
		root.right = new node(23);
		root.left.left = new node(4);
		root.left.left.left = new node(2);
		root.left.right = new node(11);
		root.right.left = new node(19);
		root.right.left.right = new node(20);
	}
	
	public void createTree3() {
		root = new node(50);
		root.left = new node(10);
		root.right = new node(22);
		root.left.left = new node(11);
		root.left.right = new node(12);
		root.right.right = new node(24);
		root.right.right.left = new node(23);
	}
	
	public void createTree4() {
		int[] num = {10, 8, 15, 2, 9, 18, 14, 20, 11, 17};
		
		for (int i : num) {
			insert(i);
		}
	}
	
	public void createTree5() {
		int[] num = {50,30,70,10,20,25,40,45,60,55,65};
		
		for (int i : num) {
			insert(i);
		}
	}
	
	public void createTree6() {
		int[] num = {40,20,70,30,25,35,32,55,85,80};
		
		for (int i : num) {
			insert(i);
		}
	}
	
	public void insert(int new_data) {
		if (root == null) {
			root = new node(new_data);
		}else {
			node current_node = root;
			while(true) {
				if (new_data < current_node.data) {
					if(current_node.left == null) {
						current_node.left = new node(new_data);
						break;
					}
					current_node = current_node.left;
					
				}else {
					if (current_node.right == null) {
						current_node.right = new node(new_data);
						break;
					}
					current_node = current_node.right;
				}
			}
		}
	}
	
	public void searchDeleteNode(int target) {
		Queue<node> queue = new ArrayDeque<node>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int levelsize = queue.size();
			node current_node = queue.poll();
			parent = current_node;
			
			if(parent.data == target) {
				deleteNode = parent;
				break;
			}
			
			for (int i=0; i < levelsize; i++) {
				if(current_node.left != null) {
					if (current_node.left.data == target) {
						deleteNode = current_node.left;
						queue.clear();
						break;
					}
					
					queue.add(current_node.left);
				}
				
				if(current_node.right != null) {
					if(current_node.right.data == target) {
						deleteNode = current_node.right;
						queue.clear();
						break;
					}
					queue.add(current_node.right);
				}
			}
		}
		
	}
	public void delete(int target) {
		searchDeleteNode(target);
		if (root == null) {
			System.out.println("Empty tree");
		}else if (deleteNode == null) {
			System.out.println("Cannot found data");
		}else {
			//Case 1: Delete Leaf Node
			if (deleteNode.left == null && deleteNode.right == null) {
				if (parent.left != null && parent.left.data == deleteNode.data) {
					parent.left = null;
				}else {
					parent.right = null;
				}
			}
			//Case 2: Delete a node with only 2 children
			else if (deleteNode.left != null && deleteNode.right != null) {
				node successorParent = deleteNode;
				node successor = deleteNode.right;
				
				while(successor.left != null) {
					successorParent = successor;
					successor = successor.left;
				}
				deleteNode.data = successor.data;
			}
			//Case 3 Delete a node with only 1 child
			else {
				if (deleteNode.left != null) {
					if (parent.left != null && parent.left.data == deleteNode.data) {
						parent.left = deleteNode.left;
					}else {
						parent.right = deleteNode.left;
					}
				}else {
					if(parent.left != null && parent.left.data == deleteNode.data) {
						parent.left = deleteNode.left;
					}else {
						parent.right = deleteNode.right;
					}
				}
			}
		}
	}
}

















