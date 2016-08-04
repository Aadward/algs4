package algs4;

import util.Graph;
import util.In;
import util.Stack;

public class BreathFirstPaths {
	private boolean[] marked;
	private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点,记录路径上一个顶点
	private final int s; //起点
	
	public BreathFirstPaths(Graph G, int s){
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}	
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
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
		int end = 244;
		BreathFirstPaths bfp = new BreathFirstPaths(new Graph(new In(args[0])), start);
		System.out.println(start + "->" + end + ":" + bfp.hasPathTo(end));
		System.out.print("path:");
		for(int i : bfp.pathTo(end)){
			if(i == start){
				System.out.print(i);
			}else{
				System.out.print("->" + i);
			}
		}
	}
}
