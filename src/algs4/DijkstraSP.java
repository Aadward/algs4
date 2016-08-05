package algs4;

import util.DirectedEdge;
import util.EdgeWeightedDigraph;
import util.In;
import util.IndexMinPQ;
import util.Stack;

public class DijkstraSP {
	private final int start;
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		start = s;
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int i = 0; i < G.V(); i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0;
		pq = new IndexMinPQ<Double>(G.V());
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()){
			relax(G,pq.delMin());
		}
	}
	
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge edge : G.adj(v)){
			int to = edge.to();
			if(distTo[to] > distTo[v] + edge.weight()){
				//如果新发现路径比原有路径权重小
				distTo[to] = distTo[v] + edge.weight();
				edgeTo[to] = edge;
				//如果这个顶点已经在PQ中，改变权重；如果不在，insert
				if(pq.contains(to)){
					pq.changeKey(to, distTo[to]);
				}else{
					pq.insert(to, distTo[to]);
				}
			}
		}
	}
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public boolean hasPathTo(int v){
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)){
			throw new RuntimeException("Can't achieve");
		}
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		while(v != start){
			stack.push(edgeTo[v]);
			v = edgeTo[v].from();
		}
		return stack;
	}
	
	
	public static void main(String[] args) {
		In in = new In("F:/mediumEWD.txt");
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		DijkstraSP sp = new DijkstraSP(G,0);
		for(DirectedEdge edge : sp.pathTo(100)){
			System.out.println(edge);
		}
		System.out.println("total weight:" + sp.distTo(100));
	}
}
