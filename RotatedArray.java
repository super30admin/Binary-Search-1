// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 Divide the array into two halves and individually check if the left half is sorted and right half is sorted. 
 If the target is less than mid, update left and right accordingly. 
 If nums[mid] == target, return index. 
 */
public class RotatedArray {
    public int search(int[] nums, int target){
        int left =0; 
        int right = nums.length-1; 
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target)
            return mid;
            if(nums[left] <= nums[mid]){
            if(target >= nums[left] && target < nums[mid]){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
            }
            else{
                if(target > nums[mid] && target <= nums[right])
                    left = mid+1;
                    else 
                    right = mid-1;
                }
            }
        
    return -1;
}
}