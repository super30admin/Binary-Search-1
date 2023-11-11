class Solution {
public:
/*
0   1   2   3   4   5   6
4   5   6   7   0   1   2

4   4
*/

    int search(vector<int>& nums, int target) {
        int low=0,high=nums.size()-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>=nums[low]) {
                if(nums[mid]>target && nums[low]<=target) {
                    high=mid-1;
                } else low=mid+1;
            } else {
                if(nums[mid]<target && nums[high]>=target) {
                    low=mid+1;
                } else high=mid-1;
            }
        }
        return -1;
    }
};