//Step 1. find the largest and lowest points wrt to target by moving along each row.
//Step 2. Once we found the range ,we can binary search from low to high
//Complexity-)(n logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      for(int i=0;i<matrix.length;i++)
        {
            int start=0;
            int end=matrix[i].length-1;
            if(matrix[i][end]==target || matrix[i][start]==target)
            {
                return true;
            }
            while(start<=end)
            {
                int mid=(start+end)/2;
                if(matrix[i][mid]==target)
                {
                    return true;
                }
                else if(matrix[i][mid]<target)
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return false;
    }
}