// Time Complexity : O(log(n))
// Space Complexity : Auxiliary space complexity is O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -


// LC 33 : Search in rotated sorted array
//In rotated sorted array, use Binary Search algorithm. Identify the sorted side of mid value. Check target in sorted
//side and move high and low pointers accordingly
class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int mid;

        while(low <= high) {
            mid = low + (high - low)/2;

            //Check if target is mid
            if(target == nums[mid])
                return mid;
            else if(nums[low]<=nums[mid]) {
                //else Check if the array is left sorted
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
            //It is right sorted
            else {
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }

        }

        return -1;
    }
}
