package sundry;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	public static void main(String[] args) {
		List<List<String>> lists = new PalindromePartitioning().partition("abccba");
		for(List<String> list : lists){
			for(String s : list){
				System.out.println(s + " ");
			}
			System.out.println();
		}
	}
	
    private List<List<String>> lists = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<String>();
        recursion(list,s.toCharArray(),0,statArray(s.toCharArray()));
        return lists;
    }
    
    private void recursion(List<String> list, char[] ch, int index, boolean[][] dp){
        int len = ch.length;
        if(index >= len){
            lists.add(new ArrayList<String>(list));
            return;
        }
        for(int i = 0; index + i < len; i++){
            if(dp[index][index + i]){
                list.add(charArrayToString(ch,index,index+i));
                recursion(list,ch,index + i + 1,dp);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean[][] statArray(char[] ch){
        int len = ch.length;
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
        	for(int j = i; j >=0; j--){
        		dp[i][j] = true;
        	}
        }
        for(int i = 1; i < len; i++){
            for(int j = 0; i + j < len; j++){
                if(ch[j] == ch[i+j])  dp[j][i+j] = dp[j+1][i+j-1];
                else  dp[j][i+j] = false;
            }
        }
        return dp;
    }
    
    private String charArrayToString(char[] ch, int begin, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = begin; i <= end; i++){
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
