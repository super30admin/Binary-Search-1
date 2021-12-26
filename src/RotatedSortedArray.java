// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        int size = nums.length;
        while(l<=h)
        {
            int mid = l + (h-l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target && nums[mid]>target){
                    h = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(nums[h]>=target && nums[mid]<target)
                {
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}