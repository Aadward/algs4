package sundry;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {
	
	public static void main(String[] args) {
		String begin = "hot";
		String end = "dog";
		Set<String> set = new HashSet<String>();
		String[] ss = new String[]{"hot","dog"};
		WordLadder.addAll(set, ss);
		System.out.println(new WordLadder().ladderLength(begin,end,set));
	}
	public static void addAll(Set<String> set, String[] ss){
		for(String s : ss){
			set.add(s);
		}
	}
	
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set1.add(beginWord);
        set2.add(endWord);
        return helper(set1,set2,wordList,1);
    }
    
    private int helper(Set<String> set1, Set<String> set2, Set<String> wordList, int level){
        if(set1.size() > set2.size())  return helper(set2,set1,wordList,level);
        
        for (String word : set1) { wordList.remove(word); };
        for (String word : set2) { wordList.remove(word); };
        
        Set<String> next = new HashSet<String>();
        //是否找到
        for(String s1 : set1){
            for(String s2 : set2){
                if(isNear(s1,s2))  return level + 1;
            }
        }
        for(String s1 : set1){
            for(String wl : wordList){
                if(isNear(s1,wl))  next.add(wl);   
            }
        }
        if(next.size() == 0)  return 0;
        set1 = next;
        return helper(set1,set2,wordList,level + 1);
        
    }
    
    private boolean isNear(String s1, String s2){
        if(s1 == null ^ s2 == null)  return false;
        else if(s1 == null && s2 == null)  return true;
        else{
            if(s1.length() != s2.length())  return false;
            else{
                int count = 0;
                for(int i = 0; i < s1.length(); i++){
                    if(s1.charAt(i) != s2.charAt(i))  count++;
                    if(count >= 2)  return false;
                }
                return (count == 1) ? true : false;
            }
        }
    }
}
