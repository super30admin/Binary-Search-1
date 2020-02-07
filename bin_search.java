// Time Complexity : O(Log(N)) -> Complexity for binary search
// Space Complexity : O (1) -> No extra space have been used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//I knew the binary search logic but couldn't implement by myself

// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int start = 0;
        int end = nums.length -1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) return mid;
            if(nums[start]<=nums[mid]){ // left search
               if(nums[start] <= target && target <=nums[mid]){
                   end = mid -1;
               }else{
                   start = mid + 1;
               } 
            }else{ // right search
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
