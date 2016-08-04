package algs4;

import util.Bag;
import util.Edge;
import util.EdgeWeightedGraph;
import util.In;
import util.IndexMinPQ;


/**
 * PrimMST<br />
 * 即时Prim最小生成树<br />
 * 排除无效边，空间复杂度O(E),时间复杂度O(ElogV)
 */
public class PrimMST {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Edge> pq;
	
	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		for(int i = 0; i < G.V(); i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Edge>(G.V());
		
		distTo[0] = 0.0;
		pq.insert(0, new Edge(0, 0, 0));
		while(!pq.isEmpty()){
			visit(G, pq.delMin());
		}
	}
	/**
	 * 将顶点V加入到树中
	 * @param G
	 * @param v
	 */
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge edge : G.adj(v)){
			int w = edge.other(v);
			//判断w是否已经在树中
			if(marked[w])  continue;
			if(edge.weight() < distTo[w]){
				//如果此条边才是w的最佳边，则将edgeTo[w]替换
				edgeTo[w] = edge;
				distTo[w] = edge.weight();
				//如果pq中已经有这个顶点的其他边，替换
				if(pq.contains(w))  pq.changeKey(w, edge);
				else  pq.insert(w, edge);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> ret = new Bag<Edge>();
		for(Edge edge : edgeTo){
			//edgeTo[0]为null
			if(edge != null){
				ret.add(edge);
			}
		}
		return ret;
	}
	
	public double weight(){
		double ret = 0.0;
		for(Edge edge : edgeTo){
			//edgeTo[0]为null
			if(edge != null){
				ret += edge.weight();
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		In in = new In("F:/mediumPrim.txt");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		PrimMST mst = new PrimMST(G);
		for(Edge edge : mst.edges()){
			System.out.println(edge);
		}
		System.out.println("total weight:" + mst.weight());
	}
}
