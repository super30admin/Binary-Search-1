// Time Complexity : O(log n)
// Space Complexity : O(1) -- search on input array with constant space (is that still O(n)?)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
        // find pivot
        int low = 0;
        int high = nums.length-1;
        int mid = low + (high-low)/2;
        int pivot = 0;

        if(nums[low] >= nums[high]){
            while(low < high){
                if(nums[mid] > nums[high]){
                    low = mid + 1;
                } else {
                   high = mid; 
                }
                mid = low + (high-low)/2;
            }
        }

        pivot = low;

        //System.out.println(nums[pivot]);

        if(nums[pivot] == target) return pivot;

        // Now binary search by dividing search space according to pivot
        if(nums[nums.length-1] >= target){
            low = pivot+1;
            high = nums.length-1;
            //System.out.println("Search second half");
        } else {
            high = pivot-1;
            low = 0;
            //System.out.println("Search first half");
        }

        mid = low + (high-low)/2;

        while(low < high){

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid - 1;
            }

            mid = low + (high-low)/2;
        }

        return low < nums.length && nums[low] == target ? low : -1;
    }
}
