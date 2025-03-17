
//Time Complexity : O(log(mn))
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes in finding row and column values using mid
/*
Approach:
Given: Integers in each row are sorted from left to right
       First integer of each row is greater than the last integer of the previous row.

 1. find the index of mid element using binary search on the 2D array range [0, m*n]
 2. Compare the mid element value with target, retrun true if found
 3. If mid value greater than target, repeat from step 1 on left half
 4. If mid value less than target, repeat from step 1 on right half
*/

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int right=m*n-1;
        int left=0;
        int mid, midElem;
        while(left<=right)
        {
            mid=(left+right)/2;
            midElem = matrix[mid/n][mid%n];   //finding mid elem in 2D matrix

            if(target==midElem)
                return true;

            else if(midElem<target)
                left=mid+1;

            else
                right=mid-1;
        }

        return false;
    }
}