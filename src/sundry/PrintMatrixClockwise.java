package sundry;

public class PrintMatrixClockwise {
	
	public static void print(int[][] matrix){
		if(matrix.length <= 0 || matrix[0].length <=0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int startR = 0, startC = 0, endR = rows - 1, endC = cols - 1;
		while((rows + 1) / 2 - 1 >= startR && (cols + 1) / 2 - 1 >= startC){
			//只有一列
			if(startC == endC){
				for(int i = startR; i <= endR; i++){
					System.out.print(matrix[i][startC]+ " ");
				}
			}
			//只有一行
			else if(startR == endR){
				for(int i = startC; i <= endC; i++){
					System.out.print(matrix[startR][i]+ " ");
				}
			}else{
				for(int i = startC; i <= endC; i++){
					System.out.print(matrix[startR][i] + " ");
				}
				for(int i = startR + 1; i <= endR; i++){
					System.out.print(matrix[i][endC] + " ");
				}
				for(int i = endC - 1; i >= startC; i--){
					System.out.print(matrix[endR][i] + " ");
				}
				for(int i = endR - 1; i > startR; i--){
					System.out.print(matrix[i][startC] + " ");
				}
			}
			startR ++;
			startC ++;
			endR --;
			endC --;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[][] n1 = new int[][]{
				{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
		};
		int[][] n2 = new int[][]{
				{1,2,3,4},{5,6,7,8},{9,10,11,12}
		};
		int[][] n3 = new int[][]{
				{1}
		};
		int[][] n4 = new int[][]{
				{1,2,3,4}
		};
		int[][] n5 = new int[][]{
				{1},{2},{3},{4}
		};
		int[][] n6 = new int[][]{
				
		};
		print(n1);
		print(n2);
		print(n3);
		print(n4);
		print(n5);
		print(n6);
	}
}
