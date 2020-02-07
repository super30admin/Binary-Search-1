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
        
        int low = 0, high = 1;
        
        //trying to find the exact range for searching the target element
        while(high<target){
          low = high;
          high = high * 2;
        }
        
        while(low<=high){
            int mid = low + (high - end)/2;
            
            if(nums[mid] == target) return mid;
            if(nums[mid]<target){ 
               low = mid + 1;
            }else{
              high = mid - 1;
            }
        }
        return -1;
    }
}
