/**
 * Time Complexity : O(log(N) where N is total length of the array
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

public class SearchInRotatedSortedArray {
    public static void main(String arge[]){
        int[] nums = {2,3,5,6,0,1};
        int target = 3;
        Search s = new Search();
        System.out.println(s.search(nums, target));
    }
}

class Search{
    public int search(int[] nums, int target) {
        int idx = -1;
        if(nums == null || nums.length == 0){
            return idx;
        }

        int len = nums.length;
        int low = 0, high = len - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int curr = nums[mid];

            if(curr == target){
                idx = mid;
                break;
            }
            if(nums[low] <= nums[mid]){
                //sorted part
                if(nums[low] <= target && target < nums[mid]){
                    //target is within the range
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return idx;
    }
}
