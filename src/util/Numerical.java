package util;

public class Numerical {
	public static int gcd(int firstNum, int secondNum){
		if(firstNum < 0)  firstNum = Math.abs(firstNum);
		if(secondNum < 0)  secondNum = Math.abs(secondNum);
		if(firstNum < secondNum){
			int temp = firstNum;
			firstNum = secondNum;
			secondNum = temp;
		}
		return (secondNum>0)?gcd(secondNum,firstNum%secondNum):firstNum;
	}
	
	public static long gcd(long firstNum, long secondNum){
		if(firstNum < 0)  firstNum = Math.abs(firstNum);
		if(secondNum < 0)  secondNum = Math.abs(secondNum);
		if(firstNum < secondNum){
			long temp = firstNum;
			firstNum = secondNum;
			secondNum = temp;
		}
		return (secondNum>0)?gcd(secondNum,firstNum%secondNum):firstNum;
	}
	
	
	public static void main(String[] args){
		System.out.println(gcd(-12, 30));
	}
}
