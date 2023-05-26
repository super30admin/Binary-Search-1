# Time Complexity : O(log n) where n = number of elements
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


/*We find the middle element of the array, check which side of the middle has elements are increasing uniformly and run binary search through that side of the array*/

class Solution {
public:
    int search(vector<int>& nums, int target) {

        int n = nums.size();
        int left = 0;
        int right = n-1;
        int mid;

        while(left<=right)
        {
            mid = left+(right-left)/2;

            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>=nums[left])
            {
                if(target<=nums[mid] && target>=nums[left])
                    right = mid-1;
                else
                    left = mid+1;
            }
            else
            {
                if(target>=nums[mid] && target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
};