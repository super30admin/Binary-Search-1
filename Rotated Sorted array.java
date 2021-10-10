// Time Complexity :log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(target==nums[mid]) return mid;
            if(nums[start]>nums[mid]){
               if(binarySearch(mid+1,end,nums,target)!=-1)return binarySearch(mid+1,end,nums,target);
                end=mid;
            }else{
                if(binarySearch(start,mid,nums,target)!=-1)return  binarySearch(start,mid,nums,target)
                start=mid+1;
            }
        }
        
        return -1;
    }
    
    public int binarySearch(int start,int end,int[] nums,int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) start=mid+1;
            else end=mid-1;
        }
        
        return -1;
    }
}