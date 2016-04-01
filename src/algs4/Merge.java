package algs4;

import util.SortUtils;

/**
 * �鲢�����Զ����µ�β�ݹ�鲢����
 * 
 *
 */
public class Merge {
	private static Comparable[] aux;
	
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];  //����ռ�
		sort(a,0,a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(lo >= hi)  return;
		int mid = lo + (hi - lo) / 2;
		//�ݹ�
		sort(a,lo,mid);  
		sort(a,mid+1,hi);
		//���������������鲢
		if(!SortUtils.less(a[mid], a[mid+1]))//���mid >= mid+1��˵����Ҫ����
			merge(a, lo, mid, hi);
	}
	
	//��a[lo,mid]��a[mid+1,hi]�鲢�����߶��Ѿ�����
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		
		int i = lo, j = mid + 1;
		
		//��a[]���Ƶ�aux[]
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		//�鲢��a[]
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
