package algs4;

import util.ResizingArrayQueue;
import util.StdIn;
import util.StdOut;

public class Josephus {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		int M = StdIn.readInt();
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
