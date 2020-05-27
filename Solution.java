// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No practiced the same problem for one of the interviews, wondering if it is the most optimal solution

public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        // Normal binary search condition 
        while(start <= end){
            
            //intialize the mid(pivot)
            int mid = start + (end-start) /2 ;
            
            //if the pivot itself is the target return
            if(nums[mid] == target){
                return mid;
            }
            
            //else if checking if mid > start element if yes then checking if the target               
            //start and less than mid element if yes intialize end as mid - 1
            else if (nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                }
                
                // if false then will check from right of the mid
                else{
                    start = mid + 1;
                }
            }
            
            // if the else if condition is failing means the taget is located on the sub-array             
            //right of the pivot
            else {
                if(target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid-1;
                }
            }
            
        }
        
        return -1;

    }
    
    }