package sundry;

public class HowManyCoins {
	public static void main(String[] args) {
		int[] coins = {1,3,5};
		System.out.println(count(coins,13));
	}
	
	private static int count(int[] coins, int target){
		int[] MIN = new int[target + 1];
		for(int i = 0; i < MIN.length; i++){
			MIN[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i <= target; i++){
			for(int c: coins){
				if(i > 0 && i - c >= 0){
					MIN[i] = Math.min(MIN[i-c]+1, MIN[i]);
				} else if(i == 0){
					MIN[i] = 0;
				}
			}
		}
		return MIN[target];
	}
}
