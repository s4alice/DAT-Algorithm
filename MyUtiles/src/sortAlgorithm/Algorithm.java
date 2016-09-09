package sortAlgorithm;

public class Algorithm{
	static int n[]={5,6,4,5,0,5,3,6,4,8,9,1,20,0,7,4,5,6,7,1};


	public void InsertSort(){
		int arr_index;
		int j;
		for(int i=1;i<n.length;i++){
			arr_index=n[i];
			for(j=i-1;j>=0;j--){
				if(arr_index<n[j])
					n[j+1]=n[j];
				else
					break;
			}
			n[j+1]=arr_index;


		}
	}
	public void ShellSort(){
		int arr_index,inner,outter;
		int h=1;
		while(h<n.length/3)
			h=h*3+1;
		while(h>0){
			for(outter=h;outter<n.length;outter+=h){
				arr_index=n[outter];
				for(inner=outter-h;inner>=0;inner-=h){
					if(n[inner]>arr_index){
						n[inner+h]=n[inner];
					}else{
						break;
					}
				}
					n[inner+h]=arr_index;
				

			}
			h=(h-1)/3;
		}

	}

	public void QuickSort(int left,int right){
		if(left<right){
			int base=n[left];
			int i=left,j=right;
			do{
				while(n[i]<base && i<right)
					i++;
				while(n[j]>base && j>left)
					j--;
				if(i<=j){//Why =
					int temp=n[i];
					n[i]=n[j];
					n[j]=temp;
					i++;
					j--;
				}
			}while(i<=j);//Why =
			if(left<j)
				QuickSort(left,j);
			if(right>i)
				QuickSort(i,right);

		}

		return;

	}
	public void MergeSort(){
		int[] array=new int[n.length];
		reMergeSort(array,0,n.length-1);
	}
	public static void main(String... args){

		Algorithm ag=new Algorithm();
		ag.MergeSort();
		for(int k:n)
			System.out.print("  "+k);
		System.out.println();
		}
	
	
	
	
	
	
	

	public void reMergeSort(int[] array,int lower,int higher){
		System.out.println("lower is "+lower+"  higher is "+higher);
		if(lower==higher)
			return;
		int mid=(lower+higher)/2;
		reMergeSort(array,lower,mid);
		reMergeSort(array,mid+1,higher);
		merge(array,lower,mid+1,higher);
	}

	public void merge(int[] array,int lowerbound,int higherPtr,int upbound){
		int lowerPtr=lowerbound;
		int num=upbound-lowerbound+1;
		int mid=higherPtr-1;
		int j=0;
		while(higherPtr<=upbound && lowerPtr<=mid)
			if(n[lowerPtr]<n[higherPtr])
				array[j++]=n[lowerPtr++];
			else
				array[j++]=n[higherPtr++];
		while(higherPtr<=upbound)
			array[j++]=n[higherPtr++];
		while(lowerPtr<=mid)
			array[j++]=n[lowerPtr++];
		for(j=0;j<num;j++)
			n[lowerbound+j]=array[j];

	}
}




