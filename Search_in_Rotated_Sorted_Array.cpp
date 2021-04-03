// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size()-1;
        int m = 0;
        while(l<=r){
            m = l + (r-l)/2;
            if(target == nums[m]){
                return m;
            }
            else if(nums[m]>=nums[l]){
                if(target<nums[m] && target>=nums[l]){
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(target> nums[m] && target <= nums[r]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
};
