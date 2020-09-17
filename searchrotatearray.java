// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        //binary search over the array
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid]==target){
                return mid;
            }
            //compare elements from rotated point and apply binary search
            else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target< nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            else {
                if(target > nums[mid] && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
                
            }
        }
        return -1;
    }
    
}