// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : It ran successfully
// Any problem you faced while coding this : None

class Solution {
public:
    int rotatedBinarySearch(std::vector<int>& nums, int target, int high, int low){
        if(nums.size() == 0) return -1;
        if(high < low) return -1;
        int mid = low + (high - low)/2;
        if(target == nums[mid]){
            return mid;
        }
        else if(nums[low] <= nums[mid]){ //left is sorted
            if(target >= nums[low] && target <= nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        else{ //Right is sorted
            if(target >= nums[mid] && target <= nums[high]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return rotatedBinarySearch(nums, target, high, low);
    }

    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        return rotatedBinarySearch(nums, target, high, low);
        
    }
};