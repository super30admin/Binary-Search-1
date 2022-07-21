// Time Complexity :0(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

//in every rotated sorted array one side of the array will be always sorted find the left or rigght side of the array is sorted and apply binary search to the sorted array

class Solution {
    public int search(int[] nums, int target) {
    if(nums==null ||nums.length==0) return -1;
    
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid] == target) return mid; 
           else if(nums[low]<=nums[mid])
            {  //left sorted array
                if(nums[low] <=target && nums[mid] >target){
                    high = mid-1;
                    }
                else{
                    low = mid +1;
                }
            }
            else{
                //right sorted array
                if(nums[mid] < target && nums[high] >= target){
                    low= mid+1;
                }else{
                    high= mid-1;
                }
            }
        }
          
        
        return -1;
        
    }
}