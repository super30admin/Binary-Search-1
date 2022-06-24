// Time Complexity : o(log m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;    
        int low=0;
        int high=(m*n)-1;  
        
        while(low<=high){
            int mid=low+(high-low)/2; //to avoid int overflow
            if(target==matrix[mid/n][mid%n]) return true;
            if(target>matrix[mid/n][mid%n]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
    return false;
    }
}

MY APPROACH:
 Here we are considering 2d Matrix as 1D array 
 if we get low and high we can simply find mid then we can divide array and search but we will divide on the basis of mid number if mid we will get 5(1D index) after dividing and selecting 1st part we can get low=0 high=4 but we need to compare mid always 
** we only need to compare mid element always so indexes like low and high will be of 1D also is fine.

1. Now mid element in matrix for row = mid(1Dindex) / n(elements in row) 
				 column = mid % n(elements in row)

Now matrix[mid/n][mid%n]==target then return otherwise divide binary search like mid>target high=mid-1;  or mid<target  low=mid+1; again new mid and compare it with target