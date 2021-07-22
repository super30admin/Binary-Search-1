// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        
        //firstly I am doing a binary search to find the smallest element in the array.
        
        int first=0;
        int last=nums.length-1;
        int mid=0;
        
        while(first<last){
            mid=(first+last)/2;
            if(nums[mid]>nums[last]){
                first=mid+1;
            }
            else{
                last=mid;
            }
        }
        
        int start=first;
        first=0;
        last=nums.length-1;
        
        if(target>=nums[start] && target<=nums[last]){
            first=start;
        }else{
            last=start-1;
        }
        
        while(first<=last){
            mid=(first+last)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                first=mid+1;
            }else{
                last=mid-1;
            }
            
        }
        return -1;
        
        
        
    }
}


