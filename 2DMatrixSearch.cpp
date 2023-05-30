// Time Complexity : O(logm*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int start = 0; 
        int end = matrix.size()-1; 

        while(start <= end) {
            int mid = (start+end)/2;
            if(target >= matrix[mid][0]) {
                int midEnd = matrix[mid].size()-1; 
                if(target <= matrix[mid][midEnd]) {
                    return vanillaBinarySearch(matrix[mid], target);
                } else start = mid+1; 
            } else end = mid-1; 
        }

        return false;     
    }

    bool vanillaBinarySearch(vector<int>& nums, int target) {
        int start = 0; 
        int end = nums.size()-1; 

        while(start <= end) {
            int mid = (start+end)/2; 
            if(target == nums[mid]) return true; 
            if(target < nums[mid]) end = mid-1; 
            else start = mid+1; 
        }

        return false; 
    }
};