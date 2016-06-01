package sundry;

public class LPS {
	
	public static int lps(char[] s, int head, int tail){
		if(head > tail)  return 0;
		if(head == tail)  return 1;
		if(s[head] == s[tail])  return lps(s,head + 1, tail - 1) + 2;
		return Math.max(lps(s,head + 1, tail),lps(s,head, tail - 1));
	}
	
	public static void main(String[] args) {
		char[] c = "google".toCharArray();
		System.out.println(lps(c,0,c.length - 1));
	}
}
