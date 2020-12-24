
public class SearchMatrix {
	 public static boolean searchMatrix(int[][] matrix, int target) {
	        for(int i=0;i<matrix.length;i++)
	        {
	        	for(int j=0;j<matrix[i].length;j++)
	        	{
	        		if(matrix[i][j]>target)
	        			break;
	        		else if(matrix[i][j]==target)
	        			return true;
	        		else
	        			continue;
	        	}
	        }
	        return false;
	    }
	 public static void main(String args[])
	 {
		 int[][] arr = {{1, 3,5,7}, {10,11,16,20},{23,30,34,50}};
		 System.out.print("print"+searchMatrix(arr,35));
	 }
}
