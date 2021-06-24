// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We can use Binary Search approach and find mid and if target is equal to mid element then we can return its index or else
-->If mid element is greater than or equal to start element, then first half is sorted array
and we can check if target is greater than start and less than mid value, then update right = mid -1 which will search just first half of the array as our target lies there
Or else left=mid+1 as target might lie in right half of the array
--> if mid element is less than start elment then 2nd half of the array is sorted.
 if target is within the range of mid and end element then left= mid+1 (narrowing the search possibilities)
 or else right = mid-1 (search in left half of the array)
 */

class Solution {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(target<=nums[mid] && target>=nums[left])
                    right = mid-1;
                else
                    left = mid+1;
            } else{
                if(target<=nums[right] && target>nums[mid] ){
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}