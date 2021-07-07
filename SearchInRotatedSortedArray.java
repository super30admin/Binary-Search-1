//time - o(log n) with constant space
//please help me with nums[] having duplicates, I am thinking that <= and >= will handle it but it is not

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[low] <= nums[mid])
            {
                if(target >= nums[low] && target < nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(target >= nums[mid + 1] && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
