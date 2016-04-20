package sundry;

public class LIS {
	public static void main(String[] args) {
		System.out.println(LIS1(new int[]{ 2,1,5,3,6,4,8,9,7}));
	}
	
	private static int LIS1(int[] nums){
		int[] ret = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			if(i == 0)  ret[i] = 1;
			for(int j = 0; j < i; j++){
				if(nums[j] <= nums[i])  
					ret[i] = (ret[i] > ret[j] + 1)?ret[i]:ret[j] + 1;
			}
		}
		int max = 0;
		for(int r : ret){
			max = (r > max)?r:max;
		}
		return max;
	}
}
