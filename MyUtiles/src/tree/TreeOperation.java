package tree;


public class TreeOperation {
	
	public TreeInfo root;
	
	public TreeInfo find(int key){
		TreeInfo current=root;
		while(current.key!=key){
			if(key<current.key){
				current=current.leftChild;
			}else if(key>current.key){
				current=current.rightChild;
			}
			if(current==null)
				return null;
			
		}
		return current;
	}
	
	
	
	public void insert(int key,double idate){
		TreeInfo current=root;
		TreeInfo toInsert=null;
		while(true){
			TreeInfo parent=current;
			if(key<current.key){
				current=current.leftChild;
				if(current==null){
					toInsert=new TreeInfo(key, idate, null, null);
					parent.leftChild=toInsert;
					return;
				}
			}else{
				current=current.rightChild;
				if(current==null){
					toInsert=new TreeInfo(key, idate, null, null);
					parent.rightChild=toInsert;
					return;
				}
			}
		}
	}
	
	public void inOrder(TreeInfo current){
		if(current==null)
			return;
		inOrder(current.leftChild);
		System.out.println("Key:"+current.key+",Data:"+current.idate);
		inOrder(current.rightChild);
	}

	public void preOrder(TreeInfo current){
		if(current==null)
			return;
		System.out.println("Key:"+current.key+",Data:"+current.idate);
		preOrder(current.leftChild);
		preOrder(current.rightChild);
	}
	
	public void lastOrder(TreeInfo current){
		if(current==null)
			return;
		lastOrder(current.leftChild);
		lastOrder(current.rightChild);
		System.out.println("Key:"+current.key+",Data:"+current.idate);

	}
	
	public TreeInfo min(){
		TreeInfo current=root;
		TreeInfo parent=current;
		while(current!=null){
			parent=current;
			current=current.leftChild;
		}	
		return parent;
		
	}
	
	public TreeInfo max(){
		TreeInfo current=root;
		TreeInfo parent=current;
		while(current!=null){
			parent=current;
			current=current.rightChild;
		}	
		return parent;
		
	}
	
	public boolean delete(int key){
		TreeInfo parent = root;
		TreeInfo current = root;
		boolean isLeftChild=true;
		while(current.key!=key){
			parent=current;
			if(current.key<key){
				current=current.leftChild;
				isLeftChild=true;
			}else{
				current=current.rightChild;
				isLeftChild=false;
			}
			if(current==null)
				return false;
		}
		if(current.leftChild==null && current.rightChild==null){//要删除的节点无子节点
			if(current==root)
				root=null;
			else if(isLeftChild)
				parent.leftChild=null;
			else if(!isLeftChild)
				parent.rightChild=null;
		}
		else if(current.rightChild==null){//要删除的节点有左子节点
			if(current==root)
				root=root.leftChild;
			else if(isLeftChild)
				parent.leftChild=current.leftChild;
			else if(!isLeftChild)
				parent.rightChild=current.leftChild;
		}else if(current.leftChild==null){//要删除的节点有右节点
			if(current==root)
				root=current.rightChild;
			else if(isLeftChild)
				parent.leftChild=current.rightChild;
			else if(!isLeftChild)
				parent.rightChild=current.rightChild;
		}
		else{//要删除的节点有两个子节点
			TreeInfo successor = getSuccessor(current);
			if(current==root)
				root=successor;
			else if(isLeftChild)
				parent.leftChild=successor;
				
			else if(!isLeftChild)
				parent.rightChild=successor;
			successor.leftChild=current.leftChild;
		}
		return true;
	}
	
	public TreeInfo getSuccessor(TreeInfo delNode){//得到后继节点并将后继节点的原右子树与移位后的右子树设置好
		TreeInfo successor = delNode;
		TreeInfo successorParent = delNode;
		TreeInfo current = delNode.rightChild;
		while(current!=null){
			successorParent = successor;
			successor = current;
			current=current.leftChild;
		}
		if(successor!=delNode.rightChild){
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		
		return successor;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
