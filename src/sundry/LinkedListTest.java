package sundry;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	
	public int i;

	public static void main(String[] args) {
		List<LinkedListTest> list = new LinkedList<LinkedListTest>();
		LinkedListTest t = new LinkedListTest();
		list.add(t);
		System.out.println(t == list.get(0));
		
		
	}

}
