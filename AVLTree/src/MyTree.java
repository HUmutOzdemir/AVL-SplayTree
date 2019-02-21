

import java.util.ArrayList;

public class MyTree {

	public MyNode root = null;
	public int height() {
		return height(root);
	}
	protected int height(MyNode node) {
		if(node==null) {
			return 0;
		}else {
			return Math.max(height(node.right),height(node.left))+1;
		}
	}
	public void add(int value) {
		root = add (root,value);
	}
	protected MyNode add(MyNode node,int value) {
		if(node==null) {
			node = new MyNode(value);
		}else if(value>node.value) {
			node.right = add(node.right,value);
		}else if(value<node.value) {
			node.left = add(node.left,value);
		}
		return node;
	}
//	public void add(int v) {
//		MyNode newNode = new MyNode(v);
//		if (root == null) {
//			root = newNode;
//		} else {
//			MyNode current = root;
//			MyNode parentOfCurrent = null;
//			while (current != null) {
//				parentOfCurrent = current;
//				if (v > current.value) {
//					current = current.right;
//				} else {
//					current = current.left;
//				}
//			}
//
//			if (v > parentOfCurrent.value) {
//				parentOfCurrent.right = newNode;
//			} else {
//				parentOfCurrent.left = newNode;
//			}
//		}
//	}

	public String preOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			s += n.value + ",";

			if (n.left != null)
				s += preOrderVisit(n.left);

			if (n.right != null)
				s += preOrderVisit(n.right);
		}
		return s;
	}

	public String inOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			if (n.left != null)
				s += inOrderVisit(n.left);
			s += n.value + ",";
			if (n.right != null)
				s += inOrderVisit(n.right);
		}
		return s;
	}

	public String postOrderVisit(MyNode n) {
		String s = "";
		if (n != null) {
			if (n.left != null)
				s += postOrderVisit(n.left);

			if (n.right != null)
				s += postOrderVisit(n.right);

			s += n.value + ",";
		}
		return s;
	}

	public void printPreOrder() {
		preOrderVisit(root);
	}

	public String printInOrder() {
		return inOrderVisit(root);
	}

	public void printPostOrder() {
		postOrderVisit(root);
	}

	public String bft() {
		String s = "";
		ArrayList<MyNode> st = new ArrayList<MyNode>();

		st.add(root);
		while (!st.isEmpty()) {
			MyNode n = st.remove(0);

			if (n.left != null) {
				st.add(n.left);
			}
			if (n.right != null) {
				st.add(n.right);
			}
			s += n.value + ",";
		}
		if (s != null && s.length() > 0 && s.charAt(s.length() - 1) == ',') {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}
	public void remove(int value) {
		root=remove(root,value);
	}
	protected MyNode remove(MyNode node, int value) {
		if(node==null) {
			return null;
		}
		if(node.value>value) {
			node.left=remove(node.left,value);
		}else if(node.value<value) {
			node.right=remove(node.right,value);
		}else {
			if(node.left==null&&node.right==null) {
				node=null;
			}else if(node.right==null) {
				node=node.left;
			}else if(node.left==null) {
				node=node.right;
			}else {
				MyNode temp = node.left;
				while(temp.right!=null) {
					temp=temp.right;
				}
				node.value=temp.value;
				node.left=remove(node.left,temp.value);
			}
		}
		return node;
	}
}
