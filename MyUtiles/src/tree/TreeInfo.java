package tree;

public class TreeInfo {
	public int key;
	public double idate;
	public TreeInfo leftChild;
	public TreeInfo rightChild;
	public TreeInfo(){
		
	}
	public TreeInfo(int key, double idate, TreeInfo leftChild, TreeInfo rightChild) {
		super();
		this.key = key;
		this.idate = idate;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	
}
