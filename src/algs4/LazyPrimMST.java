package algs4;

import util.Edge;
import util.EdgeWeightedGraph;
import util.In;
import util.MinPQ;

/**
 * LazyPrimMST<br />
 * 延时Prim最小生成树<br />
 * 将所有的边不管有效还是无效加入到了堆，空间复杂度O(E),时间复杂度O(ElogE)
 */
public class LazyPrimMST {
	private boolean[] marked;
	private MinPQ<Edge> pq;
	private ResizingArrayQueue<Edge> mst;//生成最小树的边
	
	public LazyPrimMST(EdgeWeightedGraph G){
		this.marked = new boolean[G.V()];
		//堆中最多存储边的数量
		this.pq = new MinPQ<Edge>(G.E());
		this.mst = new ResizingArrayQueue<Edge>();
		//假设0连通
		visit(G, 0);
		while(!pq.isEmpty()){
			Edge edge = pq.delMin();
			int v = edge.either();
			int w = edge.other(v);
			//如果已经失效
			if(marked[v] && marked[w]){
				continue;
			}
			mst.enqueue(edge);
			if(!marked[v])  visit(G,v);
			if(!marked[w])  visit(G,w);
		}
		
	}
	
	/**
	 * 将v的邻接边加入到堆中
	 * @param G
	 * @param v
	 */
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge edge : G.adj(v)){
			if(!marked[edge.other(v)]){
				pq.insert(edge);
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
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		LazyPrimMST mst = new LazyPrimMST(G);
		for(Edge edge : mst.edges()){
			System.out.println(edge);
		}
		System.out.println("total weight:" + mst.weight());
	}
}
