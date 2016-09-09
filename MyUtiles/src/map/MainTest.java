package map;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex(new Vertex('A'));
		g.addVertex(new Vertex('B'));
		g.addVertex(new Vertex('C'));
		g.addVertex(new Vertex('D'));
		g.addVertex(new Vertex('E'));
		g.addVertex(new Vertex('F'));
		g.addVertex(new Vertex('G'));
		g.addVertex(new Vertex('H'));

		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		g.topo();
//		for(int i=0;i<g.topoArray.length;i++){
//			System.out.println(g.topoArray[i]);
//		}
		System.out.println("---------------------------");
	}

}
