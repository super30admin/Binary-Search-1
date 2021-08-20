//Time complexity: O(log N)
//Space complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            //if the element at the mid is the target return the index of mid.
            if(nums[mid] == target) {
                return mid;
            }
            //if the element at the mid is greater than the element at low, then we can the says that
            //the elements in the left side are in increasing order.
            //left side is sorted.
            else if(nums[mid] >= nums[low]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //right is sorted;s
            else {
                if(target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}