// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size()-1;
        while(l<=r){
           int m = (l+r)/2;
            if (nums[m]==target){
                return m;
            }
            else if (nums[l]<= nums[m]){
                if (target < nums[m] && target >= nums[l]){
                    r = m -1;
                } else {
                    l = m + 1;
            }}
            else {
                if (target > nums[m]&& target <= nums[r]){
                    l = m + 1;
                } else {
                    r = m -1;
            }
        
        }
        }
      return -1; 
           
    }
};