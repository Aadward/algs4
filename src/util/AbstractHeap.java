package util;

/**
 * Created by syh20 on 2016/6/17.
 */
public abstract class AbstractHeap<T extends  Comparable<T>> {
    /**
     *  默认构造方法，用于子类调用父类构造方法
     */
    protected AbstractHeap(){

    }

    /**
     * 上浮
     */
    protected abstract void up(T t);

    /**
     * 下沉
     */
    protected abstract void sink(T t);

    /**
     * 添加元素
     */
    protected abstract void addItem(T t);

    /**
     * 删除元素
     */
    protected abstract T delItem();

    public void add(T t){
        addItem(t);
        up(t);
    }


}
