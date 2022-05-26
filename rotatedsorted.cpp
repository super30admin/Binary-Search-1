
// Time Complexity : O( logn)
// Space Complexity : None except array given 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE


// Your code here along with comments explaining your approach


class Solution {
public:
    int searcharr( vector<int>& nums, int left, int right, int target ){
        if( left > right ){
            return -1;
        }
        int mid = (left + right)/2;
        if( nums[mid] == target ){
            return mid;
        } else if ( nums[mid] >= nums[left]){
            if( target <= nums[mid] && target >= nums[left]){  
                return searcharr( nums, left, mid-1, target);
            } else {
                return searcharr( nums, mid+1, right, target);
            }
        } else {
            if( target >= nums[mid] && target <= nums[right]){  
                return searcharr( nums, mid+1, right, target);
            } else {
                return searcharr( nums, left, mid-1, target);
            }
        }
    }
    
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1;
        return searcharr( nums, left, right, target );
    }
};
