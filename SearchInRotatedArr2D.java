// Time Complexity : worst case O(log N) and Best case O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int search(int[] nums, int target) {
        if( nums.length == 0 || nums == null) return -1;
        
        int left = 0;
        int right = nums.length-1;
        
        //[1,5,6,2,0,1,7]
        
        while(left < right){
            
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] > nums[right]){
                left = midpoint +1;
            } else {
                right = midpoint;
            }
             
        }
        
       
        
        int start = left;
         left = 0;
         right = nums.length-1;
        
        //to check which side of array to consider
        
        if(target >= nums[start] && target < nums[right]){
            left = start;
            
        } else{
            right = start;
        }
        
         // right >= left [2,5,6,7,0,1,4]
        
        while(right>= left){
            
            int midpoint = left + (right-left)/2;
            if(nums[midpoint] == target){
                return midpoint;
            } else if(nums[midpoint] > target){
                right = midpoint-1;
                
            }else if(nums[midpoint] < target){
                left = midpoint + 1;
            }
            
        }
        
        return -1;
    
        
    }
}