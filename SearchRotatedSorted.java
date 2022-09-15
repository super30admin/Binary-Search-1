// Time Complexity : O(log n) where n is number of elemnets in given array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public int search(int[] nums, int target) {
        //check if the given matrix is empty.
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length -1;

        while(low<=high) {
            //find mid
            int mid = low+(high-low)/2;

            //check if mid element is target
            if(target == nums[mid]) {
                return mid;
            }

            //check if elemtns at left of mid are sorted, including mid.
            if(nums[low] <= nums[mid]) {
                //target is present in sorted part. high will be mid -1
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                }//target is present in not sorted part. low will be mid + 1
                else{
                    low = mid +1;
                }

            }//elemets at right are sorted, including mid
            else {
                //target is present in sorted part. low will be mid + 1
                if(target <= nums[high] && target > nums[mid]){
                    low = mid+1;
                } //target is present in not sorted part. high will be mid -1
                else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
