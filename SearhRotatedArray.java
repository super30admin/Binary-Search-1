// #33. Search in Rotated Sorted Array
// Time Complexity : O(log(n)): n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearhRotatedArray {
        public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1;
        int m = 0;
        while(l<h){
            m = l + (h - l)/2;
            System.out.println(m);
            if (nums[m] == target) return m;
            if(nums[l] <= nums[m]){
                if(target >= nums[l] && target < nums[m]){
                    h = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                if(target > nums[m] && target <= nums[h]){
                    l = m + 1;
                }else{
                    h = m -1;
                }
            }
        }
        if(nums[l] == target) return l;
        return -1;
    }
}
