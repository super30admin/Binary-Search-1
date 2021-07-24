//Time Complexity = O(log n)
//Space Complexity = O(1)

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low=0, high = nums.size()-1, mid;
        while(low<=high)
        {
            mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid]) //left array is sorted.
            {
                if(nums[low]<=target && target<nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else    //right array is sorted.
                if(nums[mid]<target && nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
        }
        return -1;
    }
};
