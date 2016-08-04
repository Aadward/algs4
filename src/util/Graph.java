package util;

public class Graph {
	private final int V;//顶点数目
	private int E;//边的数目
	private Bag<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	//从标准输入初始化
	public Graph(In in){
		this(in.readInt());
		int E = in.readInt();//总的边长度
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(new In(args[0]));
		System.out.println(g.E());
	}
}
