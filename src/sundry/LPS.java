package sundry;

import util.StopWatch;

public class LPS {
	
	public static int lps(char[] s, int head, int tail){
		if(head > tail)  return 0;
		if(head == tail)  return 1;
		if(s[head] == s[tail])  return lps(s,head + 1, tail - 1) + 2;
		return Math.max(lps(s,head + 1, tail),lps(s,head, tail - 1));
	}
	
	public static int dplps(char[] s){
		int[][] dp = new int[s.length][s.length];
		for(int i = 0; i < s.length; i++)  dp[i][i] = 1;
		for(int i = 1; i < s.length; i++){
			for(int j = 0; i + j < s.length; j++){
				int temp = 0;
				if(s[j] == s[j + i])
					temp = dp[j+1][j+i-1] + 2;
				else
					temp = Math.max(dp[j+1][j+i],dp[j][j+i-1]);
				dp[j][j+i] = temp;
			}
		}
		return dp[0][s.length-1];
	}
	
	public static void main(String[] args) {
		char[] c = "google".toCharArray();
		StopWatch sw = new StopWatch();
		System.out.println(dplps(c) +"   ºÄÊ±:" + sw.elapsedTime());
		System.out.println(lps(c,0,c.length - 1) +"   ºÄÊ±:" + sw.elapsedTime());
	}
}
