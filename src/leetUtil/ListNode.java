package leetUtil;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public ListNode(int[] x){
		val = x[0];
		ListNode helper = this;
		for(int i = 1; i < x.length; i++){
			helper.next = new ListNode(x[i]);
			helper = helper.next;
		}
	}
}
