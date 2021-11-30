// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        int mid;
        while(l<=h){
            mid=l+(h-l)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[l]<=nums[mid])
            {
                if(target<nums[mid]&& target>=nums[l])
                    h=mid-1;
                else
                    l=mid+1;
            }
            else
            {
                if(target>nums[mid]&& target<=nums[h])
                    l=mid+1;
                else
                    h=mid-1;
            }
        }
        return -1;

    }
}
