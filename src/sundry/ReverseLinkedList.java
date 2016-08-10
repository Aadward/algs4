package sundry;


/**
 * Created by syh20 on 2016/6/15.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        ListNode ret = new ReverseLinkedList().reverseBetween(l1,1,1);
        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode point = head;
        while(--m > 0)  {
            point = point.next;
            n--;
        }
        ListNode beforeReverse = point,start = point.next;
        while(--n > 0)  point = point.next;
        ListNode end = point.next, afterReverse = point.next.next;
        reverse(start,end);
        beforeReverse.next = end;
        start.next = afterReverse;
        return head.next;
    }

    private void reverse(ListNode start, ListNode end){
        if(start.next == null || start == end)  return;
        if(start.next != end)  reverse(start.next,end);
        start.next.next = start;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
