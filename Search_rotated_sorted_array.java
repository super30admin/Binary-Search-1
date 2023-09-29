// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially got time limit exceeded error, then fixed the boundries

// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(int[] nums, int target) {
    int l= 0, r=nums.length-1;
    while (l<=r)
    {
        int mid = (l+ r)/2;
        if(nums[mid] == target){
            return mid;
        }
        if( nums[l] <= nums[mid] ){
            if ( target >= nums[l]  &&  target < nums[mid] ){
            r = mid -1 ;      
            }
            else  
            l= mid +1;     
        }
        else {
            if ( target <= nums[r]  && target > nums[mid]  ){
                l = mid+1 ;
            }
            else r = mid-1;
        }  
     
    }
        return -1;
    }
}
