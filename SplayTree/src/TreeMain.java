

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeMain {
	public static boolean graphicsAllowed = true;
	public static ArrayList<Integer> dfsOrder = new ArrayList<Integer>();
	public static ArrayList<Integer> bfsOrder = new ArrayList<Integer>();

	/*
	 * Perform depth-first-traversal. The nodes in the tree are traversed
	 * by going as deep as possible via the left node. When you reach the end, 
	 * step one level back (up), and try the same with the right child (if possible).
	 * The DFS traversal order of the nodes is placed in dfsOrder list.  
	 * 
	 * @param tree The root node of the tree to be traversed.
	 */
	public static void dfsTraversal(MyNode root) {
		if (root == null)
			return;
		dfsOrder.add(root.value);
		dfsTraversal(root.left);
		dfsTraversal(root.right);		
	}

	/*
	 * Perform breadth-first-traversal. The nodes in the tree are traversed row-by-row.
	 * The BFS traversal order of the nodes is placed in bfsOrder list.  
	 * 
	 * @param tree		The root node of the tree to be traversed.
	 */
	public static void bfsTraversal(MyNode root) {
		LinkedList<MyNode> queue = new LinkedList<MyNode>();
		MyNode p;
		
		queue.add(root);
		while (! queue.isEmpty()) {
			p = queue.remove();
			bfsOrder.add(p.value);
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);			
		}
		
	}

	public static void main(String[] args) {

		// Create a tree
		SplayTree tree = new SplayTree();
		tree.add(10);
		tree.add(7);
		tree.add(20);
		tree.add(9);
		tree.add(19);
		tree.add(25);
		tree.add(8);
		tree.add(13);
		tree.add(0);
		tree.add(16);
		tree.add(22);
		tree.add(17);
		tree.add(4);
		tree.add(3);
		tree.add(12);
		tree.remove(22);
		// Draw the tree also in graphics
		if (graphicsAllowed) {
			BinaryTreeView btv = new BinaryTreeView("Input Tree", tree.root, 400, 400);
			btv.refresh();
		}

		dfsTraversal(tree.root);
		System.out.println("Depth-First-Search Traversal:   " + dfsOrder);

		bfsTraversal(tree.root);
		System.out.println("Breadth-First-Search Traversal: " + bfsOrder);
	}
}
