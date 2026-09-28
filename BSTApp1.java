
public class BSTApp1 {

	public static void main(String[] args) {
		BinarySearchTree bst = sampleTree1();

		System.out.println();
		System.out.println("Minimum Node is " + bst.findMinimum().data);
		System.out.println("Maximum Node is " + bst.findMaximum().data);

		int target = 15;
		System.out.println("Is " + target + " in BST => " + bst.findSpecificData(target));

		int delNode = 60;
		bst.searchDeleteNode(delNode);
		System.out.println("Parent is " + bst.getParent().data);
		System.out.println("Delete Node is " + bst.getDeleteNode().data);

		bst.delete(delNode);
		System.out.println();
		bst.printTree(bst.getRoot(), 0);
	}
	
	public static BinarySearchTree sampleTree1() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.sampleTree1();
		bst.printTree(bst.getRoot(), 0);
		return bst;
	}

}
