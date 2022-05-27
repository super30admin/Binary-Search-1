// Time complexity - It is O(logn) since we are applying binary search on the array. We are doing it in one pass and always reducing our search space by half.
// Space complexity - O(n) since our search depends on the number of elements in the array? But I am not sure. Is my answer correct?
// Problems faced - No!
// It runs on leetcode.

class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size() == 0)
            return -1;
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid]) // left side is sorted.
                {
                // check if the target value lies on the sorted side.
                if(nums[mid] > target && nums[low] <= target){
                    // can apply a binary search here to find the element.
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
            else // right side is sorted
            {
                // check if the target value lies on the sorted side.
                if(nums[mid] < target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
};
