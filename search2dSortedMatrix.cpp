// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Getting 2d index from the flat index


class Solution {
public:

    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // edge case
        if(!matrix.size()) return false;

        int rows = matrix.size();
        int columns = matrix[0].size();

        // getting the bounds 
        int low = 0;
        int high = (rows * columns)-1;

        //binary search implementation assuming the array is flat
        while(low<=high){
            int mid = low + (high-low)/2; // to avoid integer overflow

            // getting the 2d value using the number of columns
            int midValue = matrix[mid/columns][mid%columns];
            if(midValue == target) return true;
            else if (target < midValue)
                high = mid-1;
            else
                low = mid + 1;
        }
        return false;
    }
};