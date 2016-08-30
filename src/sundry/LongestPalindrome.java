package sundry;

/**
 * Created by syh20 on 2016/8/25.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int start = 0, end = 1;
        for(int index = 0; index < s.length(); index++){
            int range = 0;
            while(index + range < s.length() && index - range >=0 && s.charAt(index + range) == s.charAt(index - range)){
                range++;
            }
            range--;
            if((range * 2 + 1) > end - start){
                start = index - range;
                end = index + range + 1;
            }
            range = 0;
            if(index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)){
                while(index + 1 + range < s.length() && index - range >=0 && s.charAt(index + 1 + range) == s.charAt(index - range)){
                    range++;
                }
                range--;
                if((range * 2 + 2) >end - start){
                    start = index - range;
                    end = index + range + 2;
                }
            }
        }
        return s.length() > 0 ? s.substring(start,end) : s;
    }

    public String longestPalindromeDP(String s){
        //remove null and empty
        if(s == null || s.length() < 1)  return "";
        int[] result = new int[2];
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; i + j < s.length(); j++){
                if(s.charAt(j) == s.charAt(i+j)){
                    if(j+1 < i+j-1 && dp[j+1][i+j-1] == 0){
                        dp[j][i+j] = 0;
                    }else{
                        dp[j][i+j] = dp[j+1][i+j-1] + 2;
                        if(dp[j][i+j] > result[1] - result[0]){
                            result[0] = j;
                            result[1] = i+j;
                        }
                    }
                }else{
                    dp[j][i+j] = 0;
                }
            }
        }

        return s.substring(result[0],result[1]+1);
    }

    public String longestPalindromeLCS(String s){
        s = " " + s;
        int len = s.length();
        char[] source = s.toCharArray();
        char[] reverse = new char[len];
        reverse[0] = source[0];
        for(int i = 1; i < len; i++){
            reverse[i] = source[len - i];
        }
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for(int i = 1; i < len; i++){
            for(int j = 1; j < len; j++){
                if(source[i] == reverse[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int lcsLen = dp[len-1][len-1];
        int[] ret = new int[lcsLen];
        int i = len - 1, j = len - 1;
        while(i >= 0 && j >= 0){
            if(dp[i][j] != dp[i-1][j] && dp[i][j] != dp[i][j-1]){
                ret[--lcsLen] = i;
                i--;
                j--;
            }else if(dp[i][j] == dp[i-1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j-1]){
                j--;
            }
            if(lcsLen == 0)  break;
        }
        StringBuilder sb = new StringBuilder();
        for(int temp : ret){
            sb.append(source[temp]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("123",16));
        System.out.println(new LongestPalindrome().longestPalindrome("fewofewuibgfoabafeihfniepfnhipeddddqwdew"));
        System.out.println(new LongestPalindrome().longestPalindromeDP("fewofewuibgfoabafeihfniepfnhipeddddqwdew"));
        System.out.println(new LongestPalindrome().longestPalindromeLCS("fewofewuibgfoabafeihfniepfnhipeddddqwdew"));
    }
}
