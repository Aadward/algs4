package sundry;

public class KthNumber {
	public static void main(String[] args) {
		int[] nums = {1,3,5,2,2};
		KthNumber k = new KthNumber();
		System.out.println(k.find(nums, 2));
	}
	
	public int find(int[] nums, int k){
		int lo = 0;
		int hi = nums.length - 1;
		return find(nums, lo ,hi ,k - 1);
	}
	
	private int find(int[] nums, int lo, int hi, int k){
		int mid = partition(nums, lo, hi);
		if(mid == k)  return nums[mid];
		else if(mid > k)  return find(nums,lo,mid-1,k);
		else  return find(nums,mid+1,hi,k);
	}
	
	public int partition(int[] a, int lo, int hi){
		int v = a[lo];
		int i = lo, j = hi + 1;
		
		while(true){
			while(a[++i] < v)
				if(i == hi)
					break;
			while(v <a [--j])
				if(j == lo)
					break;
			if(i >= j)
				break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		int temp = a[lo];
		a[lo] = a[j];
		a[j] = temp;
		return j;
	}
}
