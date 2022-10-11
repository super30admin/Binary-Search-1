// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int h = nums.size() - 1;
        
        while (l <= h) {
            int mid = l + (h-l)/2;
            
            if (nums[mid] == target) return mid;
            
            //left sorted case
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target &&  target < nums[mid]) 
                    h = mid - 1;
                 else 
                    l = mid + 1;
                
            } else {
                //right sorted case
                if (nums[mid] <= target && target<= nums[h]) 
                    l = mid + 1;
                else 
                    h = mid - 1;
            }
        }    
        return -1;
    }
};
