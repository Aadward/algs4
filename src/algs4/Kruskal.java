package algs4;

import util.Edge;
import util.EdgeWeightedGraph;
import util.In;
import util.MinPQ;
import util.QuickUnionUF;

public class Kruskal {
	private MinPQ<Edge> pq;
	private ResizingArrayQueue<Edge> mst;
	private QuickUnionUF UF;
	
	public Kruskal(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>(G.E());
		for(Edge edge : G.edges()){
			pq.insert(edge);
		}
		mst = new ResizingArrayQueue<Edge>();
		UF = new QuickUnionUF(G.V());
		while(pq.size() > 0 && mst.size() < G.V() - 1){
			Edge edge = pq.delMin();
			int v = edge.either();
			int w = edge.other(v);
			if(UF.connected(v, w)){
				continue;
			}else{
				UF.union(v, w);
				mst.enqueue(edge);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double ret = 0.0;
		for(Edge edge : edges()){
			ret += edge.weight();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		In in = new In("F:/mediumPrim.txt");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		Kruskal mst = new Kruskal(G);
		for(Edge edge : mst.edges()){
			System.out.println(edge);
		}
		System.out.println("total weight:" + mst.weight());
	}
	
	
}
