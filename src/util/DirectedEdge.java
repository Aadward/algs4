package util;

public class DirectedEdge {
	private int v;
	private int w;
	private double weight;
	
	
	public DirectedEdge(int from, int to, double weight) {
		this.v = from;
		this.w = to;
		this.weight = weight;
	}

	public double weight(){
		return weight;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DitectedEdge: ").append(v).append("->")
		.append(w).append(" weight:").append(weight);
		return sb.toString();
	}
	
	
}
