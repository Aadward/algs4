package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * 数组初始长度为2，每当存满则数组长度乘2，当数组使用不足1/4时，数组长度除2
 * 
 * @author syh
 *
 * @param <E>
 */
public class ResizingArrayQueue<E> implements Iterable<E>{
	
	private E[] array;
	private int first,last,N;
	
	public ResizingArrayQueue (){
		this.array = (E[]) new Object[2];
		this.first = 0;
		this.last  = 0;
		this.N = 0;
	}
	
	public ResizingArrayQueue (int size){
		this.array = (E[]) new Object[size];
		this.first = 0;
		this.last  = 0;
		this.N = 0;
	}
	
	public void enqueue(E e){
		if(N == array.length)  resize(array.length * 2);
		array[last++] = e;
		if(last == array.length)  last = 0;
		N++;
	}
	
	public E dequeue(){
		if(isEmpty())  throw new NoSuchElementException("Queue underflow");
		E e = array[first];
		array[first] = null;
		N--;
		first++;
		if(first == array.length) first = 0;
		if(N > 0 && N == array.length / 4)  resize(array.length/2);
		return e;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void resize(int max){
		E[] temp = (E[]) new Object[max];
		for(int i = 0; i < N; i++){
			temp[i] = array[(i+first) % array.length];
		}
		first = 0;
		last = N;
		array = temp;
		
		//System.out.println("数组长度变更："+max);
	}
	
	public E peek(){
		if(isEmpty())  throw new NoSuchElementException("Queue underflow");
		return array[first];
	}

	@Override
	public Iterator<E> iterator() {
		return new ResizingArrayIterator();
	}
	
	private class ResizingArrayIterator implements Iterator<E>{
		
		int i = 0;

		@Override
		public boolean hasNext() {
			return i  < N;
		}

		@Override
		public E next() {
			if(!hasNext())  throw new NoSuchElementException();
			E e = array[(i+first) % array.length];
			i++;
			return e;
		}

		@Override
		public void remove() {throw new UnsupportedOperationException();}
		
	}
	
	public static void main(String[] args){
		ResizingArrayQueue<Integer> q = new ResizingArrayQueue<Integer>();
        for(int i = 0; i < 100 ; i++){
        	q.enqueue(i);
        }
        for(int i : q){
        	StdOut.print(i+"\n");
        }
        for(int i = 0; i < 100 ; i++){
        	q.dequeue();
        }
	}
	
}
