// Time Complexity : O(logN)
// Space Complexity : O(1), recursive stack not sure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class searchRotatedSortedArray
{
    public int search(int[] nums, int target)
    {
        return recursiveSearch(nums, 0, nums.length - 1, target);
    }

    private int recursiveSearch(int[] nums, int low, int high, int target)
    {

        if(low > high) return -1;

        int middle = low + (high - low)/2;

        if(nums[middle] == target) return middle;

        int ans = -1;

        if(nums[middle] < target){
            ans = recursiveSearch(nums, middle + 1, high, target);
            if(ans > -1) return ans;
            ans = recursiveSearch(nums, low, middle - 1, target);
        }

        else
        {
            ans = recursiveSearch(nums, low, middle - 1, target);
            if(ans > -1) return ans;
            ans = recursiveSearch(nums, middle + 1, high, target);
        }

        return ans;
    }

}
