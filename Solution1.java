// Time Complexity : log(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1;
        int mid = 0;       
        if(h == 0)
            return -1;
        while (l <= h)
        {
            mid = l + (h-l)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > nums[l])
            {
                if ((nums[mid] > target) && (nums[l]<=target))
                    h = mid - 1;
                else
                    l = mid + 1;
            }
            else 
                if((nums[mid] < target) && (nums[h]>=target))
                    l = mid + 1;
                else
                    h = mid - 1;
        }
        return -1;
        
    }
}