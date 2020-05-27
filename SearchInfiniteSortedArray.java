// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA


// Your code here along with comments explaining your approach

public class SearchInfiniteSortedArray {
    public static int search(int[] nums, int target) {
        int low = 0, high = 1;
        while(nums[high] < target) {
            low = high;
            high *= 2;
        }
        //binary search
        while(low <= high){
            int mid = low + (high-low)/2; // to handle integer overflow
            if(nums[mid] == target) return mid;
            else if(target >= nums[mid]) low = mid+1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,27,45,49};
        System.out.println(search(nums,3));
        }
}