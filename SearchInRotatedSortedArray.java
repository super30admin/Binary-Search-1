
// Time Complexity : Add : O(log (n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if(nums == null|| nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int midpoint = left + (right - left)/2;
            if(nums[midpoint] > nums[right])
                left = midpoint + 1;
            else
                right = midpoint;
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        if(target >= nums[left] && target <nums[start])
            right = start - 1;
        else
            left = start;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid-1;
            else
                left = mid + 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
