package algs4;


import util.Graph;
import util.In;
import util.Stack;

public class DepthFirstPaths {
	
	private boolean[] marked;
	private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点,记录路径上一个顶点
	private final int s; //起点
	
	public DepthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	/**
	 * 是否存在从起点s到v的路径
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	/**
	 * s到v的路径，如果不存在返回null
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)){
			return null;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while(v != s){
			stack.push(v);
			v = edgeTo[v];
		}
		stack.push(s);
		return stack;
	}
	
	public static void main(String[] args) {
		int start = 0;
		int end = 1;
		DepthFirstPaths dfp = new DepthFirstPaths(new Graph(new In(args[0])), start);
		System.out.println(start + "->" + end + ":" + dfp.hasPathTo(end));
		System.out.print("path:");
		for(int i : dfp.pathTo(end)){
			if(i == start){
				System.out.print(i);
			}else{
				System.out.print("->" + i);
			}
		}
	}
}
