// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int RotatedbinarySearch(int low, int high, vector<int>& nums, int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2; // Prevent overflow
        if(nums[mid] == target)
            return mid;
        else if(nums[low] <= nums[mid]){ // left side is sorted
            if(nums[low] <= target && target < nums[mid]){
                return RotatedbinarySearch(low, mid - 1, nums, target); // search sorted side
            }
            else{
                return RotatedbinarySearch(mid + 1, high, nums, target); // search unsorted side
            }
        }
        else{ // Right side is sorted
            if(target > nums[mid] && target <= nums[high]){
                return RotatedbinarySearch(mid + 1, high, nums, target); // search sorted side
            }
            else{
                return RotatedbinarySearch(low, mid - 1, nums, target); // search unsorted side
            }
        }
    }
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        return RotatedbinarySearch(low, high, nums, target);
        
    }
};