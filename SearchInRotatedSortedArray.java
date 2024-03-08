// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize low as 0 and high as length - 1 of the input array.
// 2. Use binary search to find the target element.
// 3. At each step, check if the middle element is equal to the target.
// 4. If not, check if the left half or right half is sorted.
// 5. Determine which half the target might be in based on comparison with the endpoints of the sorted half.
// 6. Adjust low and high pointers accordingly to search in the appropriate half.
// 7. Repeat steps 2-6 until low is less than high.
// 8. If the loop terminates without finding the target, return -1.

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //null
        if(nums == null || nums.length ==0)
        {
            return -1;
        }
        int low=0;
        int high = nums.length-1;
        while(low < high)
        {
            // to avoid integer overflow we are taking
            int mid = low+(high-low)/2; // integer overflow -> 2456123434 + 345768904 /2
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[low] <= nums[mid])
            {
                //left sorted
                // if ele lies in that part

                if(nums[low] <= target && nums[mid] > target)
                {
                    high = mid;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                // right sorted
                //if ele lies in the part
                if(nums[mid] < target && nums[high] >= target)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid;
                }
            }
        }
        if(nums[low] == target) return low;
        return -1;
    }
}