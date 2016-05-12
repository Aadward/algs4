package sundry;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1,1,2});
		for(List<Integer> l : lists){
			for(int i : l){
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> index = new ArrayList<Integer>();
        dfs(lists,list,nums,index);
        return lists;
    }
    
    private void dfs(List<List<Integer>> lists,List<Integer> previous, int[] nums, List<Integer> index){
        if(index.size() == nums.length){
        	lists.add(previous);
        	return;
        }
        List<Integer> list = new ArrayList<Integer>(previous);
        List<Integer> indices = new ArrayList<Integer>(index);
        
        for(int i = 0; i < nums.length; i++){
            if(index.contains(i))  continue;
            list.add(nums[i]);
            indices.add(i);
            dfs(lists,list,nums,indices);
        }
    }
}