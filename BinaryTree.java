public class BinaryTree {

	private node root;

	public BinaryTree() {
		root = null;
	}
	
	public node getRoot() {
		return root;
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
	
}