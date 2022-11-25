// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int search(vector<int>& nums, int target) {
        // edge case
        if(!nums.size()) return -1;

        int low = 0;
        int high = nums.size()-1;

        // binary search 

        // either the left or the right has to be sorted 
        while(low<=high){
            int mid = low + (high-low)/2; //to avoid integer overflow
            if(target == nums[mid]) 
                return mid;

            // if left section is sorted
            if(nums[low]<=nums[mid]){

                // if the element you are looking for if in the sorted part
                // reduce search space to that half 
                if(nums[low]<=target and nums[mid]>target)
                    high = mid-1;
                else 
                    low = mid+1;
            }
            // if the right is sorted
            else { 
                if(nums[mid]<target and nums[high]>=target)
                    low = mid+1;
                else 
                    high = mid-1;
            }
        }
        return -1;
    }
};