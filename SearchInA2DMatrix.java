

//Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No


public class SearchInA2DMatrix {
	
	//Time Complexity :O(row + col)
	 public boolean searchMatrix(int[][] matrix, int target) {
	        
	        int row  = matrix.length;
	        int col = matrix[0].length;
	        int i = 0;
	        int j = col-1;

	        while(i>=0 && i<row && j>=0 && j<col){
	            if(matrix[i][j]== target)
	                return true;
	            if(target < matrix[i][j]){
	                j--;
	            }else{
	                i++;
	            }

	        }
	        return false;
	    }
	 
	//Time Complexity :O(Log(Row) + Log(Col))	 
	 public boolean searchMatrix2(int[][] matrix, int target) {
	        
	        if(matrix==null || matrix.length==0)
	            return false;;

	            int row = matrix.length;
	            int col = matrix[0].length;
	            int low = 0;
	            int high = row * col -1;

	            while(low <=high){
	                int mid = low + (high -low)/2;
	                int midVal = matrix[mid/col][mid % col];
	                if(midVal== target)
	                    return true;
	                if(midVal< target)
	                    low = mid+1;
	                else   
	                    high  = mid-1;
	            }

	        return false;

	    }
}
