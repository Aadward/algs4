package sundry;

import java.util.Random;

import util.Stack;

/**
 * 一个带有获得最小元素min()方法的栈
 */
public class MinStack<Item extends Comparable<Item>> extends Stack<Item> {
	private Stack<Item> helper;

	public MinStack() {
		super();
		this.helper = new Stack<Item>();
	}

	@Override
	public void push(Item item) {
		super.push(item);
		if(helper.isEmpty()){
			helper.push(item);
		}
		Item temp = helper.peek();
		helper.push(item.compareTo(temp) > 0 ? temp : item);
	}

	@Override
	public Item pop() {
		helper.pop();
		return super.pop();
	}
	
	public Item min(){
		return helper.peek();
	}
	
	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<Integer>();
		Random rand = new Random(47);
		for(int i = 0; i < 20; i++){
			Integer temp = rand.nextInt(100);
			System.out.print(temp + " ");
			stack.push(temp);
		}
		System.out.println();
		while(!stack.isEmpty()){
			System.out.print("min = " + stack.min());
			System.out.println("弹出 " + stack.pop());
		}
	}
	
}
