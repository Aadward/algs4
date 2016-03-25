package algs4;

import java.util.ArrayList;
import java.util.List;

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
		if(alg.equals("Merge"))  Merge.sort(a);
		if(alg.equals("QuickSort"))  QuickSort.sort(a);
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
	
	public static void sortAndPrint(List<String> algs,int N,int T){
		StdOut.printf("For %d random Doubles run %d times\n", N,T);
		for(String alg : algs){
			double time = timeRandomInput(alg, N, T);
			StdOut.printf("%s use %fs\n", alg, time);
		}
	}

	public static void main(String[] args) {
		List<String> algs = new ArrayList<String>();
		//algs.add("Selection");
		//algs.add("Insertion");
		algs.add("Shell");
		algs.add("Merge");
		algs.add("QuickSort");
		
		int N = 100000;
		int T = 100;

		sortAndPrint(algs,N,T);
	}

}
