package sundry;


public class Manacher {
	
	int maxLen , po;
	int[] lens;
	
	public static void main(String[] args) {
		Manacher s = new Manacher();
		String ret = s.longestPalindrome("abcb");
		System.out.println(ret);
	}
	
	public String longestPalindrome(String s) {
        char[] c = toCharArray(s);
        lens = new int[c.length];
        for(int i = 0; i < c.length; i++){
        	if(po + maxLen > i){
        		if(lens[2 * po - i] > (maxLen + po - i)){
        			lens[i] = lens[po] - (i - po);
        		} else if(lens[2 * po - i] < (maxLen + po - i)){
        			lens[i] = lens[2 * po - i];
        		} else{// =
        			lens[i] = lens[2 * po - i];
        			findPalindrome(c, i, lens[i]);
        		}
        	} else{
        		findPalindrome(c, i, 1);
        	}
        }
        return parse(c);
        
        
    }
	
	private char[] toCharArray(String s){
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for(int i = 0; i < s.length(); i++){
			sb.append(s.charAt(i));
			sb.append("#");
		}
		return sb.toString().toCharArray();
	}
	
	private void findPalindrome(char[] c, int i, int len){
		if(i - len < 0 || i + len > c.length - 1){
			lens[i] = len;
		} else{
			while(i - len >=0 && i + len < c.length && c[i - (len)] == c[i + (len)]){
				len ++ ;
			}
			lens[i] = len;
		}
		if(len >= maxLen){
			maxLen = len;
			po = i;
		}
	}	
	private String parse(char[] c){
		StringBuilder sb = new StringBuilder();
		int start = po - maxLen + 1;
		int end = po + maxLen - 1;
		while(start <= end){
			if(c[start]!='#')
				sb.append(c[start]);
			start ++;
		}
		return sb.toString();
	}
	
}