package sundry;

import java.util.Calendar;

import util.StopWatch;

public class Fib {
	
	//大量重复计算，效率极低
	public static long fib(int n){
		return (n == 1 || n ==2) ? 1 : (fib(n-1) + fib(n-2));
	}
	
	public static long fib(int n,int a,int b){
		if(n < 1)
			return 0;
		else if(n <= 2)
			return 1;
		else if(n == 3)
			return a + b;
		else
			return fib(n-1,b,a+b);
	}

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		System.out.println(Calendar.getInstance().getTime());
		System.out.println(fib(1,1,1) + "\n" + sw.elapsedTime());
	}

}
