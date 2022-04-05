//Binary Search is used to solve this problem.
//Time Complexity : O(n*m)

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        boolean ans = false;
        for(int i =0;i<row;i++)
        {
            if(matrix[i][0]<=target)
            {
                 ans = helper(matrix[i],target);
            }
        }
        return ans;
    }
    
    public static boolean helper(int arr[],int target)
    {
        int low = 0,high=arr.length-1;
        
        while(low<=high)
        {
            int middle = low + (high-low)/2;
            
            if(arr[middle]==target)
            {
                return true;
            }
            
            else if(arr[middle]<target)
            {
                low = middle +1;
            }
            else if(arr[middle]>target)
            {
                high = middle - 1;
            }
        }
        return false;
    }
}