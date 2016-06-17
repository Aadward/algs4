package algs4;

import util.SortUtils;

/**
 * 插入排序
 * 
 *
 */
public class Insertion {
	public static void sort(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			for(int j = i; j > 0 && SortUtils.less(a[j], a[j-1]); j--){
					SortUtils.exch(a, j, j-1);
			}
		}
	}
	
	public static void sort(Comparable[] a, int lo,int hi){
		for(int i = lo; i < hi; i++){
			for(int j = i; j > lo && SortUtils.less(a[j], a[j-1]); j--){
					SortUtils.exch(a, j, j-1);
			}
		}
	}
	
	public static void fastsort(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			Comparable newer = a[i];
			for(int j = i; j > 0; j--){
				if(SortUtils.less(newer, a[j-1]))
					a[j] = a[j-1];
				else{
					a[j] = newer;
					break;
				}
			}
		}
	}
	
	public static void main(String args[]){
		Integer[] a = {1,3,4,6,4,3,4,5,6,4,3,2,2,5,6};
		fastsort(a);
		SortUtils.show(a);
	}

}
