package util;

public class Edge implements Comparable<Edge>{
	
	private final double weight;
	private final int v;
	private final int w;
	
	public Edge(double weight, int v, int w) {
		super();
		this.weight = weight;
		this.v = v;
		this.w = w;
	}

	public double weight(){
		return this.weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int v){
		if(v == this.v)  return w;
		else if(v == this.w)  return this.v;
		else throw new RuntimeException("Not a vertex of this edge.");
	}
	@Override
	public int compareTo(Edge o) {
		if(this.weight > o.weight)  return 1;
		else if(this.weight < o.weight)  return -1;
		else  return 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(v).append("-").append(w).append(":").append(weight);
		return sb.toString();
	}

}
