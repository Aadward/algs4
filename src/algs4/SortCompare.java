package algs4;

import util.StdOut;
import util.StdRandom;
import util.StopWatch;

public class SortCompare {
	
	//µ˜”√≈≈–ÚÀ„∑®
	public static double time(String alg, Comparable[] a){
		StopWatch timer = new StopWatch();
		if(alg.equals("Selection"))  Selection.sort(a);
		if(alg.equals("Insertion"))  Insertion.sort(a);
		if(alg.equals("Shell"))  Shell.sort(a);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg,int N,int T){
		double total = 0.0;
		Double[] a = new Double[N];
		for(int t = 0; t < T; t++){
			for(int i = 0; i < N; i++){
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		
		return total;
	}

	public static void main(String[] args) {
		String alg1 = "Insertion";
		String alg2 = "Selection";
		String alg3 = "Shell";
		int N = 10000;
		int T = 100;
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		double t3 = timeRandomInput(alg3, N, T);
		
		StdOut.printf("For %d random Doubles\n    %s is ",N,alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1,alg2);
		
		StdOut.printf("%s = %f \n %s = %f.", alg1,t1,alg3,t3);
	}

}
