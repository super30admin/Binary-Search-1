// 74. Search a 2D Matrix
// Time Complexity : log(n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only
// first we will check if the left side of the array to the mid is sorted and if the left side is sorted
// then we will check if the target lies on the left side else we move to the right side of the mid.
// we will do similarly on the right side.
    
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size()-1, mid;
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[low])
            {
                //left sort check;
                if(nums[low]<=target  && nums[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(nums[high] >= nums[mid])
            {
                //right sort check;
                if(nums[mid]<target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }