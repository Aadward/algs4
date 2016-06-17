package util;

public abstract class AbstractHeap<T extends Comparable<T>> {
	
	/**
	 * 默认构造器，用于子类调用父类构造函数
	 */
	protected AbstractHeap(){}
	
	/**
	 * 当前元素数量
	 * @return number of size
	 */
	public abstract int size();
	
	/**
	 * 元素下沉，用于初始化排序和删除元素
	 */
	protected abstract void sink(T t);
	
	/**
	 * 元素上浮，用于新增元素
	 */
	public abstract void up(T t);
	
	/**
	 * 新增元素
	 */
	public void add(T t){
		addItem(t);
		up(t);
	}
	
	/**
	 * 删除元素
	 */
	public T delete(){
		return null;
	}
	
	/**
	 * 新增元素
	 */
	protected void addItem(T t){
		
	}
}
