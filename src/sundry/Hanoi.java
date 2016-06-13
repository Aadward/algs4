package sundry;

/**
 * �򵥵ĺ�ŵ��ʵ��
 * @author syh
 *
 */
public class Hanoi {
	
	private int count = 0;
	
	public void hanoi(int n, String src, String des){
		if(n >= 2){
			hanoi(n - 1, src, reverse(src, des));
			hanoi(1, src, des);
			hanoi(n - 1, reverse(src, des), des);
		} else{
			System.out.println("�ƶ�·����" + src + "-->" + des );
			count ++;
		}
	}
	
	private String reverse(String src, String des){
		if(src.equals("A") && des.equals("B")){
			return "C";
		}else if(src.equals("A") && des.equals("C")){
			return "B";
		}else{
			return "A";
		}
	}
	
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.hanoi(3, "A", "C");
		System.out.println("�����ƶ�������" + hanoi.getCount());
	}

}
