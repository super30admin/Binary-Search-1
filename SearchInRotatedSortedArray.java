/**
 * Time complexity is O(log n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int index = getTargetIndex(nums, 0);
        System.out.println(index);
    }

    private static int getTargetIndex(int[] nums, int target) {
        /*Base case*/
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        /*Performing binary search while low <= high*/
        while(low <= high){
            int mid = low + (high- low)/2; //Prevent Integer overflow
            /*If target is found at mid then return mid*/
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
