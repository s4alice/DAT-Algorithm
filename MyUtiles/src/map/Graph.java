package map;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {
	int max_size;
	int current_size;
	Vertex[] graph;
	int[][] adjMat;
	Stack<Integer> dfsNeed = new Stack<>();
	char [] topoArray;//拓扑排序后的数组

	public Graph() {
		max_size = 20;
		current_size = 0;
		graph = new Vertex[max_size];
		adjMat = new int[max_size][max_size];
		for (int i = 0; i < max_size; i++)
			for (int j = 0; j < max_size; j++) {
				adjMat[i][j] = 0;
			}
	}

	public void addVertex(Vertex v) {
		graph[current_size++] = v;
		topoArray=new char[current_size];
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
//		adjMat[end][start] = 1;   //拓扑排序为有向图
	}

	public void displayVertex(int v) {
		System.out.println(graph[v].c);
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < max_size; i++) {
			if (i != v) {
				if (adjMat[v][i] == 1 && graph[i].isVisited == false)
					return i;
			} else {
				continue;
			}
		}
		return -1;
	}

	public void dfs() {
		graph[0].isVisited = true;
		dfsNeed.push(0);
		displayVertex(0);
		int v = 0;
		while (!dfsNeed.empty()) {
			v = getAdjUnvisitedVertex(dfsNeed.peek());
			if (v != -1) {
				graph[v].isVisited = true;
				dfsNeed.push(v);
				displayVertex(v);
			} else {
				dfsNeed.pop();
			}
		}
		/**
		 * @author freya
		 */
		// while (!dfsNeed.empty()) {
		// v = getAdjUnvisitedVertex(v);
		// if (v != -1) {
		// graph[v].isVisited = true;
		// dfsNeed.push(v);
		// displayVertex(v);
		// } else {
		// dfsNeed.pop();
		// if (dfsNeed.empty())
		// break;
		// else {
		// v = dfsNeed.peek();
		// }
		//
		// }
		// }

		for (int i = 0; i < current_size; i++) {
			graph[i].isVisited = false;
		}
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedBlockingQueue<>();
		int v = 0, s;
		displayVertex(v);
		graph[v].isVisited = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.remove();
			while ((s = getAdjUnvisitedVertex(v)) != -1) {
				graph[s].isVisited = true;
				displayVertex(s);
				queue.add(s);
			}
		}

		for (int i = 0; i < current_size; i++) {
			graph[i].isVisited = false;
		}

	}

	public void mst() {
		graph[0].isVisited = true;
		dfsNeed.push(0);
		int v = 0;
		while (!dfsNeed.empty()) {
			int curr = dfsNeed.peek();
			v = getAdjUnvisitedVertex(curr);
			if (v != -1) {
				graph[v].isVisited = true;
				dfsNeed.push(v);
				displayVertex(curr);
				displayVertex(v);
				System.out.println("**********");
			} else {
				dfsNeed.pop();
			}
		}

	}
	
	//the methods below are used in map with direction
	
	public int nosuccess(){
		boolean isEdge=false;
		for(int i=0;i<current_size;i++){
			isEdge=false;
			for(int j=0;j<current_size;j++){
				if(adjMat[i][j]==1){
					isEdge=true;
					break;
				}
			}
			if(!isEdge){
				return i;
			}
		}
		return -1;
	}
	
	public void topo(){
		int origin = current_size;
		for(int a=0;a<current_size;a++){
			for(int b=0;b<current_size;b++){
				System.out.print(adjMat[a][b]+"  ");
			}
			System.out.println();
		}
		while(current_size>0){
			int current_vertex = nosuccess();
			if(current_vertex==-1){
				System.out.println("the graph must have a cycle");
				return;
			}
			topoArray[current_size-1]=graph[current_vertex].c;
			delVertex(current_vertex);

		}
		
		for(int i=0;i<origin;i++){
			System.out.println(topoArray[i]);
		}
	}
	
	
	
	
	private void delVertex(int i){
		for(int j=i;j<(current_size-1);j++){
			graph[j]=graph[j+1];
		}
		current_size--;
	}	
	
}
