package sundry;

import util.Stack;

public class StackOrder {
	/**
	 * 判断是否为出入栈序列
	 * @param in  入栈序列
	 * @param out  出栈序列
	 * @return
	 */
	public static boolean isPopOrder(Integer[] in, Integer[] out){
		Stack<Integer> inStack = new Stack<Integer>();
		if(in.length == 0 && out.length == 0)
			return true;
		else if(in.length <= 0 && out.length <= 0)
			return false;
		int index = 0;
		for(int i = 0; i < in.length;){
			if(inStack.size() > 0 && inStack.peek() == out[index]){
				inStack.pop();
				index ++;
			}else if(in[i] == out[index]){
				i++;
				index ++;
			}else{
				inStack.push(in[i++]);
			}
		}
		for(; index < out.length; index ++){
			Integer popItem = inStack.isEmpty() ? null : inStack.pop();
			if(popItem != out[index]){
				return false;
			}
		}
		
		if(!inStack.isEmpty())
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		Integer[] in = {1,2,3,4,5};
		Integer[] out1 = {4,5,3,2,1};
		Integer[] out2 = {4,3,5,1,2};
		Integer[] out3 = {2,3,4,5};
		System.out.println(isPopOrder(in, out1));
		System.out.println(isPopOrder(in, out2));
		System.out.println(isPopOrder(in, out3));
	}
}
