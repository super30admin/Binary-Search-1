// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/* The algorithm works on the basis that for a rotated sorted array either the left
* half or the right half would be sorted. So we initially check if the value is there
* in the left half, if not we update the low value to mid+1. After this we repeat the logic
* in order to find the target */

class Problem2 {
    public static int search(int[] nums, int target) {

        int low = 0 ;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] agrs){

        int arr[] = new int[]{3,5,1};
        int ans = search(arr,3);
        System.out.println("Element found at index "+ans);
    }
}