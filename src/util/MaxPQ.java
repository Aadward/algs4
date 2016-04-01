package util;


public class MaxPQ<E extends Comparable> {
	
	private E[] a;
	private int N;
	public static final int DEFAULT_MAX = 10;
	
	public MaxPQ(){
		this.a = (E[])new Comparable[DEFAULT_MAX + 1];
	}
	
	public MaxPQ(int max){
		this.a = (E[])new Comparable[max + 1];
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(E item){
		//因为a[0]没有使用，故a.length - 1
		if(N == a.length - 1){
			resize(a.length * 2);
		}
		a[++N] = item;
		swim(N);
	}
	
	public E delMax(){
		E ret = a[1];
		a[1] = a[N--];
		sink(1);
		if(N == a.length / 4)  resize(a.length / 2);
		return ret;
	}
	
	
	private void swim(int k){
		while(k > 1 && SortUtils.less(a[k/2], a[k])){
			SortUtils.exch(a, k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while(k*2 <= N){
			int j = k * 2;
			if(j  < N && SortUtils.less(a[j], a[j + 1]))  j += 1;
			if(SortUtils.less(a[k], a[j])){
				SortUtils.exch(a, k, j);
				k = j;
			}else
				break;
		}
	}
	
	private void sink(E[] a,int k,int end){
		while(k*2 <= end){
			int j = k * 2;
			if(j  < end && SortUtils.less(a[j], a[j + 1]))  j += 1;
			if(SortUtils.less(a[k], a[j])){
				SortUtils.exch(a, k, j);
				k = j;
			}else
				break;
		}
	}
	
	public void sort(E[] a){
		//让数组堆有序
		int N = a.length - 1;//101 - 1 = 100
		for(int i = N/2; i >= 1; i--){
			sink(a,i,N);
		}
		//排序
		while(N > 1){
			SortUtils.exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	
	private void resize(int max){
		E[] newArray = (E[])new Comparable[max+1];
		for(int i = 1; i <= N; i++){
			newArray[i] = a[i];
		}
		a = newArray;
	}
	

	public static void main(String[] args) {
		int count = 0;
		MaxPQ<Integer> pq = new MaxPQ<Integer>();
		for(int i = 0; i < 100; i++){
			pq.insert(StdRandom.uniform(100));
		}
		int length = pq.size();
		System.out.println("PQ长度为："+length);
		for(int i = 1; i <= length; i++){
			StdOut.print(pq.delMax() + " ");
			if(i % 10 == 0)  StdOut.println();
			count ++;
		}
		System.out.println(count);
		System.out.println("===============排序==============");
		
		Integer[] a = new Integer[101];//长度为101，0不用，1-100
		for(int i = 1; i < a.length; i++){
			a[i] = StdRandom.uniform(100);
		}
		pq.sort(a);
		for(int i = 1; i < a.length; i++){
			StdOut.print(a[i] + " ");
			if(i % 10 == 0)  StdOut.println();
		}
	}

}
