//time complexity: O(log n), binary search
//space complexity: O(1), only constant extra space (variables) used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
public:
    int findIndex(vector<int>& nums, int low, int high, int tar){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(tar == nums[mid]){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(tar<nums[mid] && tar>=nums[low]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            } else {
                if(tar > nums[mid] && tar <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
    
    int search(vector<int>& nums, int target) {
        int len = nums.size();
       // cout << len << endl;
        int index = findIndex(nums, 0, len-1, target);
        return index;
    }
};

