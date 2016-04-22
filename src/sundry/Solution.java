package sundry;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().numDecodings("17"));
	}
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')  return 0;
        else if(s.length() == 1)  return 1;
        
        int count = 0;
        List<Integer> seeds = new ArrayList<Integer>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0' && isZeroError(s.charAt(i-1)))  return 0;
            if(isConfuse(s.charAt(i-1),s.charAt(i)))  count++;
            else if(!isConfuse(s.charAt(i-1),s.charAt(i)) && count == 0){}
            else {
            	if(s.charAt(i) == '0')  count--;
                seeds.add(getIncrease(count) + 1);
                count = 0;
            }
        }
        if(count != 0)  seeds.add(getIncrease(count) + 1);
        int ret = 1;
        for(int i : seeds){
            ret *= i;
        }
        return ret;
    }
    
    private boolean isConfuse(char first, char second){
        return (second != '0' && (first == '1') || (first == '2' && second > '0' && second <= '6'));
    }
    
    private int fib(int n, int a, int b){//a,b作为初始值，避免重复计算设计的尾递归
        if(n < 1)  return 0;
        else if(n <= 2)  return 1;
        else if(n == 3)  return a + b;
        else  return fib(n-1,b,a+b);
    }
    private int getIncrease(int count){
        int ret = 0;
        for(int i = 1; i <= count; i++){
            ret += fib(i,1,1);
        }
        return ret;
    }
    private boolean isZeroError(char ch){
        if(ch == '1' || ch == '2')  return false;
        return true;
    }
}
