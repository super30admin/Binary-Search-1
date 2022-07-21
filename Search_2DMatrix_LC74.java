// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : finding the mid element , how to remember the mid/col and mid%col?


/*Since the matrix is sorted we can consider it as a 1d array and perform binary search.
We can do this by assuming it as contiguous and indexing accordingly (imaginary indexing).
we can find the row no. and column no. from the imaginary index as follows:
row no. =  mid / total no. of columns
col no. =  mid % total no. of columns*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int left =0;
        int right=row*col-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            int midelement = matrix[mid/col][mid%col];
            if(target==midelement){
                return true;
            }
             else if(target<midelement){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
        
        
        
    }
}

