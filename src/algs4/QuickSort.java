package algs4;

import util.SortUtils;

public class QuickSort {
	
	public static void sort3way(Comparable[] a){
		int lo = 0;
		int hi = a.length - 1;
		sort3way(a, lo, hi);
	}
	
	public static void sort3way(Comparable[] a, int lo, int hi){
		if(lo >= hi)  return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0)  SortUtils.exch(a, lt++, i++);
			else if(cmp > 0)  SortUtils.exch(a, i, gt--);
			else i++;
		}
		sort3way(a, lo, lt -1);
		sort3way(a, gt + 1, hi);
	}

	public static void sort(Comparable[] a){
		int lo = 0; 
		int hi = a.length - 1;
		sort(a, lo, hi);
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		int M = 10;
		if(lo + M >= hi)  {
			Insertion.sort(a,lo,hi);
			return;
		}
		int mid = partition(a,lo,hi);
		sort(a,lo,mid - 1);
		sort(a,mid + 1,hi);
	}
	
	public static int partition(Comparable[] a, int lo, int hi){
		Comparable v = a[lo];
		int i = lo, j = hi + 1;
		
		while(true){
			while(SortUtils.less(a[++i], v))
				if(i == hi)
					break;
			while(SortUtils.less(v, a[--j]))
				if(j == lo)
					break;
			if(i >= j)
				break;
			SortUtils.exch(a, i, j);
		}
		SortUtils.exch(a, lo, j);
		return j;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,3,6,3,2,4,5,7,5,3,4,5,6,7};
		//sort(a);
		sort3way(a);
		SortUtils.show(a);
	}

}
