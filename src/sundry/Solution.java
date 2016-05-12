package sundry;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[]{1,3,1,5,3}));
	}
	public int singleNumber(int[] nums) {
		if(nums.length == 0)  return 0;
        Arrays.sort(nums);
        return segment(nums,0,nums.length - 1);
    }
    
    private int segment(int[] nums, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        if(mid == hi && mid == lo)  return nums[mid];
        if(nums[mid] == nums[mid - 1]){
        	if((mid - lo) % 2 == 0)  hi = mid;
        	else  lo = mid + 1;
        }
        else if(nums[mid] == nums[mid + 1]){
        	if((hi - mid) % 2 == 0)  lo = mid;
        	else  hi = mid - 1;
        }
        else  return nums[mid];
        return segment(nums,lo,hi);
    }
}