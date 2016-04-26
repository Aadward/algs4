package sundry;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int seed = 1;
		for(int i = 0; i < 4; i++){
			List<Integer> cList = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++){
				cList.add(seed++);
			}
			list.add(cList);
		}
		System.out.println(new Triangle().minimumTotal(list));
	}
	public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++){
                if(j == 0)  triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(0));
                else if(j == triangle.get(i).size() - 1)  triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(i-1));
                else
                	triangle.get(i).set(j,triangle.get(i).get(j) +
                			((triangle.get(i-1).get(j-1) > triangle.get(i-1).get(j)) ? triangle.get(i-1).get(j):triangle.get(i-1).get(j-1)));
            }
        }
        int min = triangle.get(triangle.size()-1).get(0);
        for(int i : triangle.get(triangle.size()-1)){
            min = (i > min) ? min : i;
        }
        return min;
    }
}
