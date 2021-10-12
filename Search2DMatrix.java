// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows=matrix.length;
        int coloumn=matrix[0].length;
        
        for(int i=0;i<rows;i++)
        {
            if(target<=matrix[i][coloumn-1])
            {
                if(target>=matrix[i][0])
                {   
                    int start=0;
                    int end=coloumn-1;
                    
                    while(start<=end)
                    {
                        int mid=start+(end-start)/2;
                        
                        if(matrix[i][mid]==target)
                        {
                            return true;
                        }
                        
                        else if(target>matrix[i][mid])
                        {
                            start=mid+1;
                        }
                        
                        else
                        {
                            end=mid-1;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}