// Time Complexity  = O(log(n))
// Space Complexity  = O(1)
// Runtime: 9 ms, faster than 19.71% of C++ online submissions for Search in Rotated Sorted Array.
// Memory Usage: 11 MB, less than 75.62% of C++ online submissions for Search in Rotated Sorted Array.


class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int low = 0, high = nums.size()-1;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            
            if (nums[mid] == target) 
                return mid;
            
            if (nums[low] <= nums[mid]) 
            {
                if(target >= nums[low] && target < nums[mid]) 
                    high = mid-1;
                else
                    low = mid+1;
            }
            else 
            {
                if (target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
       return -1; 
    }
};