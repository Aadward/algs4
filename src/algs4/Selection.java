package algs4;

import util.SortUtils;

public class Selection {
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i = 0; i < n; i++){
			int min = i;
			for(int j = i; j < n; j++){
				if(SortUtils.less(a[j], a[min]))
					min = j;					
			}
			SortUtils.exch(a, i, min);
		}
	}
	
	public static void main(String args[]){
		Integer[] a = {1,3,6,3,2,4,5,7,5,3,4,5,6,7};
		sort(a);
		SortUtils.show(a);
	}
	

}
