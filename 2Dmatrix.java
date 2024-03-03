// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

//https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left=0;
        int n=matrix[0].length;
        int m=matrix.length;
        int right=m * n-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            int element= matrix[mid/n][mid%n];
            if(target==element)
                return true;
            else if(element<target)
                left=mid+1;
            else if(element>target)
                right=mid-1;
        }
        return false;
        
    }
}

