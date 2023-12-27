//33. Search in Rotated Sorted Array

/*
Binary search implementation
Time complexity: O(log N)
Space complexity: O(1)
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {

     
        if(nums.size() == 0) return -1;
        int low = 0, high = nums.size()-1;
        
        while(low <= high){
            int mid = low+(high - low)/2;

            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            else{
                if(nums[mid] < target && nums[high] >= target)  low = mid + 1;
                else high = mid - 1; 
            }
            
        }
        
        return -1;

        
        
    }
};