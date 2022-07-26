// Time Complexity : O(log(n*m))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //0 to n*m-1
        int row= matrix.length;
        int col= matrix[0].length;
        
        int left = 0;
        int right = row*col -1;
        while(left<=right)
        {
            int middle = left + (right-left)/2;
            int colPosition = findColumnPosition(middle,col);
            int rowPosition = findRowPosition(middle, col);
            int element= matrix [rowPosition] [colPosition];
            if(element == target){
                return true;
            }
            
            if(element > target)
            {
                
                right = middle -1;
            }
            else {
                left = middle +1;
            }
            
        }
        
        
        return false;
        
    }
    
    private int findColumnPosition(int index, int columns)
    {
        return index%columns;
    }
    
    private int findRowPosition(int index,int columns)
    {
        return index/columns;
    }
    public static void main(String[] args)
    {
        int[][] matrix= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
    }
}