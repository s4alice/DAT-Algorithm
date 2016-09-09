package heap;

public class Heap {

	private int maxSize;
	private int currentSize;
	private Node[] heap;

	public Heap(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
		heap = new Node[maxSize];
	}

	public boolean insert(int idata) {
		if (currentSize >= maxSize)
			return false;
		Node newNode = new Node(idata);
		heap[currentSize] = newNode;
		trinkleUp(currentSize++);
		return true;
	}

	public void trinkleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heap[index];
		while (index > 0 && bottom.getiData() > heap[parent].getiData()) {
			heap[index] = heap[parent];// shift the parent down ,and make
										// current up
			index = parent;
			parent = (index - 1) / 2;
		}
		heap[index] = bottom;

	}

	public Node remove() {
		Node top = heap[0];
		heap[0] = heap[--currentSize];
		trinkleDown(0);
		return top;
	}

	public void trinkleDown(int index) {
		Node top = heap[index];
		while (index < (currentSize - 1) / 2) {
			int largeNode;
			int leftChild = index * 2 + 1;
			int rightChild = leftChild + 1;
			if (rightChild < currentSize && heap[leftChild].getiData() < heap[rightChild].getiData())
				largeNode = rightChild;
			else
				largeNode = leftChild;
			if (top.getiData() > heap[largeNode].getiData())
				break;
			heap[index] = heap[largeNode];
			index = largeNode;
		}
		heap[index] = top;
	}
	
	public boolean change(int index,int idata){
		if(index<0 || index>=currentSize)
			return false;
		if(heap[index].getiData()<idata){
			heap[index].setiData(idata);
			trinkleUp(index);
		}
		else {
			heap[index].setiData(idata);
			trinkleDown(index);
		}
		return true;	
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
