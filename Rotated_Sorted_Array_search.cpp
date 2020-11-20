// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : logical

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0, h=nums.size()-1;
        int m;
        while(l<=h){
            m = l + (h-l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m]>=nums[l]){
                if(target>=nums[l] && target<nums[m]){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(target>nums[m] && target<=nums[h]){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
        }
        return -1;
    }
};
