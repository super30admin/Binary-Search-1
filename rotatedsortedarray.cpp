
// TC:O(logN);
// SC:O(1);

// Approach 
// Here main idea is one or both part of an array are sorted,So looking for sorted part by comapring
// low and high and then in that part checking for the target.

class Solution {
public:
    int search(vector<int>& nums, int target) {
  
        int low=0;
        int high=nums.size()-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(target==nums[mid])
            return mid;

            if(nums[low]<=nums[mid])
            {
                if(target<=nums[mid] && target >=nums[low] )
                high=mid-1;
                else
                low=mid+1;
            }
            else
            {
                if(target>=nums[mid] && target<=nums[high])
                low=mid+1;
                else
                high=mid-1;
            }

        }
        return -1;
    }
};