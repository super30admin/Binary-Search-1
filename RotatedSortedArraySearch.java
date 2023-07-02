// Time Complexity : log(n)
// Space Complexity : log(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : (confuse in space complexity)


// Your code here along with comments explaining your approach in three sentences only
//followed the binary search approach to find the elemnt in the array
public class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null) { return -1; }
        int l = 0;
        int h = nums.length-1;

        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[l]<=nums[mid]){
                if(nums[l] <= target && nums[mid] > target){
                    h = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            else {
                if(nums[mid] < target && nums[h] >= target){
                    l = mid+1;
                }
                else {
                    h = mid-1;
                }
            }
        }
        return -1;
    }
}