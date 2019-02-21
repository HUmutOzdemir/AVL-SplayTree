import java.util.LinkedList;

public class SplayTree extends MyTree{
	public void add(int v) {
		MyNode newNode = new MyNode(v);
		if (root == null) {
			root = newNode;
			return;
		} else {
			MyNode current = root;
			MyNode parentOfCurrent = null;
			while (current != null) {
				parentOfCurrent = current;
				if (v > current.value) {
					current = current.right;
				} else {
					current = current.left;
				}
			}

			if (v > parentOfCurrent.value) {
				parentOfCurrent.right = newNode;
			} else {
				parentOfCurrent.left = newNode;
			}
			newNode.parent=parentOfCurrent;
		}
		splay(newNode);
	}
	public boolean contains(int v) {
		MyNode current = root;
		MyNode parentOfCurrent = null;
		while (current != null&&current.value!=v) {
			parentOfCurrent = current;
			if (v > current.value) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		if(current==null) {
			splay(parentOfCurrent);
			return false;
		}else {
			splay(current);
			return true;
		}
	}
	public void remove(int v) {
		MyNode current = root;
		MyNode parentOfCurrent = null;
		while (current != null&&current.value!=v) {
			parentOfCurrent = current;
			if (v > current.value) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		if(current==null) {
			splay(parentOfCurrent);
			return;
		}else {
			splay(current);
		}
		MyNode leftTree = root.left;
		MyNode rightTree = root.right;
		if(leftTree!=null)
		leftTree.parent=null;
		if(rightTree!=null)
		rightTree.parent=null;
		current = rightTree;
		parentOfCurrent = null;
		while(current!=null) {
			parentOfCurrent=current;
			current=current.left;
		}
		if(parentOfCurrent==null) {
			root = leftTree;
		}else {
			splay(parentOfCurrent);
			parentOfCurrent.left=leftTree;
			leftTree.parent=parentOfCurrent;
			root = parentOfCurrent;
		}
		
	}
	private void splay (MyNode node) {
		while(node.parent!=null) {
			if(node.parent.parent==null) {
				rotate(node,node.parent);
				break;
			}
			if((node.value<node.parent.value&&node.parent.value<node.parent.parent.value)||(node.value>node.parent.value&&node.parent.value>node.parent.parent.value)) {
				rotate(node.parent, node.parent.parent);
				rotate(node,node.parent);
			}else {
				rotate(node,node.parent);
				rotate(node,node.parent);
			}
		}
	}
	private void rotate(MyNode child, MyNode parent) {
		if(child.value<parent.value) {//left child ise
			rightRotate(child, parent);
		}else {
			leftRotate(child, parent);
		}
	}
	private void rightRotate(MyNode child, MyNode parent) {
		if(parent.parent!=null) {
			if(parent.value<parent.parent.value) {//Parent left child
				parent.parent.left=child;
				child.parent=parent.parent;
			}else {//Parent right child.
				parent.parent.right=child;
				child.parent=parent.parent;
			}
		}else {
			child.parent=null;
			root = child;
		}
		MyNode leftright = parent.left.right;
		child.right = parent;
		parent.parent=child;
		parent.left=leftright;
		if(leftright!=null)
		leftright.parent=parent;
	}
	private void leftRotate(MyNode child, MyNode parent) {
		if(parent.parent!=null) {
			if(parent.value<parent.parent.value) {//Parent left child
				parent.parent.left=child;
				child.parent=parent.parent;
			}else {//Parent right child.
				parent.parent.right=child;
				child.parent=parent.parent;
			}
		}else {
			child.parent=null;
			root = child;
		}
		MyNode rightleft = parent.right.left;
		child.left=parent;
		parent.parent=child;
		parent.right=rightleft;
		if(rightleft!=null)
		rightleft.parent=parent;
	}
}
