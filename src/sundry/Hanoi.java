package sundry;

/**
 * 简单的汉诺塔实现
 * @author syh
 *
 */
public class Hanoi {
	
	private int count = 0;
	
	public void move(int n, char src, char des){
		if(n < 1)  return;
		if(n >= 2){
			move(n - 1, src, reverse(src, des));
			move(1, src, des);
			move(n - 1, reverse(src, des), des);
		} else{
			System.out.println("移动路径：" + src + "-->" + des );
			count ++;
		}
	}
	
	private char reverse(char src, char des){
		int total = 'A' + 'B' + 'C';
		if(total - src - des > 'B')  return 'C';
		else if(total - src - des < 'B')  return 'A';
		else return 'B';
	}
	
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.move(4, 'A','C');
		System.out.println("共计移动次数：" + hanoi.getCount());
	}

}
