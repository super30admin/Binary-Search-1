// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced some problem while impementing if-else condition, was confused on implementing the condition
// Approach: Performed a binary search for a better time complexity.
//           Check if the right or left half of the array is sorted. Then check if the target lies on the sorted side or not.
//           Perform the same steps until the target is found.


class RotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[low]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid -1;
                } else{
                    low = mid +1;
                }
            } else{
                if(nums[high] >= target && nums[mid] < target){
                    low = mid + 1;
                } else{
                    high = mid  -  1;
                }
            }
        }
        return -1;
    }
}