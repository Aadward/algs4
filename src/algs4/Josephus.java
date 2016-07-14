package algs4;

import util.StdIn;
import util.StdOut;

/**
 * 报数问题：求报数的顺序
 * 
 *
 */
public class Josephus {

	public static void main(String[] args) {
		int N = StdIn.readInt(); //数的数量
		int M = StdIn.readInt();  //报数的间隔
		ResizingArrayQueue<Integer> q = new ResizingArrayQueue<Integer>();
		
		for(int i = 0; i < N; i++){
			q.enqueue(i);
		}
		while(!q.isEmpty()){
			for(int i = 0; i < M; i++){
				if(i == M-1)  StdOut.print(q.dequeue()+" ");
				else  q.enqueue(q.dequeue());
			}
		}
	}

}
