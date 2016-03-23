package algs4;

import java.util.ArrayList;
import java.util.List;

import util.StdOut;
import util.StdRandom;
import util.StopWatch;

/**
 * 
 * awful solution.
 *
 */
public class Point2D {
	
	private final double x;
	private final double y;
	
	public Point2D(double x, double y){
		this.x = x;
		this.y = y;
	}	
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


	public double distanceTo(Point2D p){
		return Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
	}

	public static void main(String[] args) {
		//int N = Integer.parseInt(args[0]);
		int N = 10000;
		List<Point2D> pList = new ArrayList<Point2D>();
		for(int i = 0; i < N; i++){
			pList.add(new Point2D(StdRandom.uniform(), StdRandom.uniform()));
		}
		StopWatch sw = new StopWatch();
		double min = 2.0;
		for(int i = 0; i < pList.size(); i++){
			for(int j = i + 1; j < pList.size(); j++){
				min = (min > pList.get(i).distanceTo(pList.get(j)))?pList.get(i).distanceTo(pList.get(j)):min;
			}
		}
		double time = sw.elapsedTime();
		StdOut.print(min+"\n");
		StdOut.printf("Use Time : %f seconds.", time);
	}

}
