

public class MyNode {

	public int value;
	public MyNode left = null;
	public MyNode right = null;
	public MyNode parent = null;
	
	public MyNode(int value) {
		this.value = value;
	}
	
	public int getHeight() {
		int lH = -1;
		int rH = -1;
		
		if(left != null) {
			lH = left.getHeight();
		}
		if(right != null) {
			rH = right.getHeight();
		}
		return Math.max(rH, lH)+1;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
}
