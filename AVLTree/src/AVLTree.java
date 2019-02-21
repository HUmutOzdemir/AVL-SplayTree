

public class AVLTree extends MyTree{
	private int balancedFactor(MyNode node) {
		if(node==null) {
			return 0;
		}
		return super.height(node.right)-super.height(node.left);
	}
	private MyNode leftRotate(MyNode node) {
		MyNode rightleft = node.right.left;
		MyNode newParent = node.right;
		newParent.left=node;
		node.right = rightleft;
		return newParent;
	}
	private MyNode rightRotate(MyNode node) {
		MyNode leftright = node.left.right;
		MyNode newParent = node.left;
		newParent.right=node;
		node.left=leftright;
		return newParent;
	}
	private MyNode balance(MyNode node) {
		int bf = balancedFactor(node);
		if(bf<=-2) {
			if(balancedFactor(node.left)<0) {
				node = rightRotate(node);
			}else {
				node.left= leftRotate(node.left);
				node = rightRotate(node);
			}
		}else if(bf>=2) {
			if(balancedFactor(node.right)<0) {
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}else {
				node = leftRotate(node);
			}
		}
		return node;
	}
	protected MyNode remove(MyNode node, int value) {
		node = super.remove(node, value);
		node = balance(node);
		return node;
	}
	public void remove(int value) {
		root = remove(root,value);
	}
	protected MyNode add(MyNode node, int value) {
		node = super.add(node,value);
		node = balance(node);
		return node;
	}
	public void add(int value) {
		root = this.add(root,value);
	}
}
