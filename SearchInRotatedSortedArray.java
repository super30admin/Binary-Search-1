// Time Complexity : O(log n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//We will check if array is left sorted or right sorted
// Once we check which side is sorted we will then check if the element is lying within the sorted side range
// We will perform internal binary search operations again on the side the conditions are met.

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            if(nums[low]<= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid]<target && nums[high]>=target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}