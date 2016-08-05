package util;

import java.util.HashSet;
import java.util.Set;

public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<Edge>[] adj;
	
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[this.V];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Edge>();
		}
	}
	
	public EdgeWeightedGraph(In in){
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			addEdge(new Edge(weight, v, w));
		}
	}
	
	public void addEdge(Edge edge){
		int v = edge.either();
		int w = edge.other(v);
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		Set<Edge> edges = new HashSet<Edge>();
		for(int i = 0; i < V; i++){
			for(Edge edge : adj[i]){
				edges.add(edge);
			}
		}
		return edges;
	}
}
