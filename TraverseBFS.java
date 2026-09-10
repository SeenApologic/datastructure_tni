import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class TraverseBFS {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createTree1();    // Try to test with createTree2() and createTree3()
		tree.printTree(tree.getRoot(), 0);
		System.out.println();
		System.out.println("Postorder = " + traversal(tree.getRoot()));
	}
	public static ArrayList<Integer> traversal(node Node){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (Node != null) {
			Queue<node> queue = new ArrayDeque<node>();
			queue.add(Node);
			
			while (!queue.isEmpty()) {
				int levelsize = queue.size();	
				
				for (int i=0; i<levelsize; i++) {
					
					node current_node = queue.poll();
					list.add(current_node.data);
					
					if (current_node.left != null) {
						queue.add(current_node.left);
					}
					if (current_node.right != null) {
						queue.add(current_node.right);
					}
				}
			}
            
		}
		return list;
		
	}
}
