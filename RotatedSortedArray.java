// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target)   return 0;
            else return -1;
        }
        int left = 0, right = nums.length - 1, middle;
        while(left <= right){
            middle = left + (right - left) / 2;
            if(target == nums[middle]) return middle;
            else if (nums[middle] >= nums[left]) {
                if (target >= nums[left] && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            }
            else {
                if (target <= nums[right] && target > nums[middle]) left = middle + 1;
                else right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

}
