package algs4;

import util.SortUtils;

public class Shell {
	
	public static void sort(Comparable a[]){
		int N = a.length;
		int h = 1;
		while(h < N/3)  h = 3 * h + 1;
		
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && SortUtils.less(a[j], a[j-h]); j -= h){
					SortUtils.exch(a, j, j-h);
				}
			}
			h /= 3;
		}
	}

	public static void main(String args[]){
		Integer[] a = {1,3,6,3,2,4,5,7,5,3,4,5,6,7};
		sort(a);
		SortUtils.show(a);
	}

}
