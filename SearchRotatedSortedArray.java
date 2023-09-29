// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

public class SearchRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, h = nums.length-1;
            while(l <= h){
                int mid = l+(h-l)/2;
                if(nums[mid] == target)
                    return mid;
                if(nums[l] <= nums[mid]){
                    //left sorted array
                    if(nums[l] <= target && nums[mid] > target){
                        h = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
                else{
                    //right sorted array
                    if(nums[mid] < target && target <= nums[h]){
                        l = mid+1;
                    }
                    else{
                        h = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
