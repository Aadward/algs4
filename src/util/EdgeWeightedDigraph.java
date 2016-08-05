package util;

public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private Bag<DirectedEdge>[] adj;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int v){
		V = v;
		E = 0;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDigraph(In in){
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int from = in.readInt();
			int to = in.readInt();
			double weight = in.readDouble();
			addEdge(new DirectedEdge(from, to, weight));
		}
	}
	
	public void addEdge(DirectedEdge edge){
		int from = edge.from();
		adj[from].add(edge);
		E++;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> edges = new Bag<DirectedEdge>();
		for(Bag<DirectedEdge> bag : adj){
			for(DirectedEdge edge : bag){
				edges.add(edge);
			}
		}
		return edges;
	}
}
