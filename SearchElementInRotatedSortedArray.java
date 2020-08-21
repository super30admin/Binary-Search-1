// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target){
        int start=0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[start]){
                
                if(nums[mid]>target && nums[start]<=target){
                    end=mid-1;
                }else{
                    start=mid+1; 
                }        
            }
            else{
                
                if(nums[mid]<target && nums[end]>=target){
                    start=mid+1;
                }else{
                    end=mid-1;   
                }      
            }  
        }
        return -1;
    }
