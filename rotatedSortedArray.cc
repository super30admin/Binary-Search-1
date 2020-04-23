class Solution {
public:
    int RotatedbinarySearch(int low, int high, vector<int>& nums, int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2;
        if(nums[mid] == target)
            return mid;
        else if(nums[low] <= nums[mid]){
            if(nums[low] <= target && target < nums[mid]){
                return RotatedbinarySearch(low, mid - 1, nums, target);
            }
            else{
                return RotatedbinarySearch(mid + 1, high, nums, target);
            }
        }
        else{
            if(target > nums[mid] && target <= nums[high]){
                return RotatedbinarySearch(mid + 1, high, nums, target); 
            }
            else{
                return RotatedbinarySearch(low, mid - 1, nums, target);
            }
        }
    }
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size() - 1;
        return RotatedbinarySearch(low, high, nums, target);
        
    }
};