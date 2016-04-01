package algs4;

import util.SortUtils;

/**
 * 归并排序（自顶向下的尾递归归并排序）
 * 
 *
 */
public class Merge {
	private static Comparable[] aux;
	
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];  //分配空间
		sort(a,0,a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(lo >= hi)  return;
		int mid = lo + (hi - lo) / 2;
		//递归
		sort(a,lo,mid);  
		sort(a,mid+1,hi);
		//将两个有序的数组归并
		if(!SortUtils.less(a[mid], a[mid+1]))//如果mid >= mid+1，说明需要排序
			merge(a, lo, mid, hi);
	}
	
	//将a[lo,mid]和a[mid+1,hi]归并（两者都已经有序）
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		
		int i = lo, j = mid + 1;
		
		//将a[]复制到aux[]
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		//归并到a[]
		for(int k = lo; k <= hi; k++){
			if(i > mid)  a[k] = aux[j++];
			else if(j > hi)   a[k] = aux[i++];
			else if(SortUtils.less(aux[i], aux[j]))  a[k] = aux[i++];
			else  a[k] = aux[j++];
		}
	}
	
	public static void main(String[] args){
		Integer[] a = {1,3,4,6,4,3,4,5,6,4,3,2,2,5,6};
		sort(a);
		SortUtils.show(a);
	}
}
