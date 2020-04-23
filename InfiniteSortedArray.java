// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution{
    public int binarySearch(int[] nums, int target){
        int low=0;
        int high=1;
        while(nums[high]<target){
            low=high;
            high=high*2;
        }
        return search(nums,low,high,target);
    }
    public int search(int[] nums, int low, int high ,int target){

    while(low <= high){    
        int mid = low + (high-low)/2;

        if(nums[mid]==target)
            return mid;
        
        if(nums[low]<=target && target<nums[mid])
            high = mid-1;
        
        if(nums[mid]<=target && target<nums[high])
            low = mid+1;
    }
    return -1;
    }
}