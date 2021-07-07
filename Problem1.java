class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        else if(nums.length == 1)
        {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        else
        {
            int l = 0;
        
            while(l < nums.length-1)
            {
                if(nums[l] == target)
                    return l;
                else if(nums[l+1] < nums[l])
                    break;
                ++l;
            }

            int low = l, high = nums.length;

            while(low < high)
            {
                int mid = (low + high) / 2;

                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] < target)
                    low = mid+1;
                else
                    high = mid;
            }

            return -1;
        }
    }
}
