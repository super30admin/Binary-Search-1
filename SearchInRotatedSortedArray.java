// Time Complexity : O(logn) reducing the search space by 2 times
// Space Complexity : O(1) constant space independent of the range of length of input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //1.Initialize
    //2.do Binary Search
    //2->a: check if left is sorted
    //2->b: check if right is sorted
    public int search(int[] nums, int target) {
        //1
        int low = 0;
        int high = nums.length-1;
        
        //2. binarySearch
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            //2->a:
            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && nums[mid] > target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            
            //2->b:
            else{
                if(nums[high] >= target && nums[mid] < target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
                
            }
        }
        return -1;
    }
}