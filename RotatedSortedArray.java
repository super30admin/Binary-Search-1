// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//found the changing point and did binary search

class Solution {
    public int search(int[] nums, int target) {
        int change=rotate(nums);
        System.out.println(change);
        if(change==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        else if(target==nums[change])
            return change;
        else if(target<nums[change] || target>nums[change-1])
            return -1;
        else if(target>nums[change] && target<=nums[nums.length-1]){
            return binarySearch(nums,target,change,nums.length-1);
        }
        else
            return binarySearch(nums,target,0,change-1);
      
               
    }
    public int binarySearch(int[] arr,int target,int s,int e){
         while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]<target){
                s=mid+1;
            }
            if(arr[mid]>target){
                e=mid-1;
            }
        }
        return -1;
        
    }
    public int rotate(int[] nums){
        int last=nums.length-1;
        int change=-1;
        if(nums.length<=1)
            return -1;
        int start=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                change=i;
                break;
            }
        }

        return change;
        
    }
}