// Time Complexity : O(log n) : n is number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, unable to use single pass approach


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int result;
        if(nums.length<1){
            return -1;
        }
        if(nums.length<2){
            if(nums[0]==target){
                return 0;
            }
            return -1;
        }
        int point = rotationalPoint(nums);
        if(point==-1){
            return binarySearch(nums, 0, nums.length-1, target);
        }
        if(nums[point]==target){
            return point;
        }
        else{
            if(target>nums[nums.length-1]){
                return binarySearch(nums, 0,point, target);
            }else{
                return binarySearch(nums,point,nums.length-1, target);
            }
        }
    }
    
    public int rotationalPoint(int[] nums){
        int start=0; int end = nums.length-1;
        if(nums[start]<nums[end]){
            return -1;
        }
         while(start<=end){
            int mid = (start + end)/2;
             if(nums[mid]>nums[mid+1]){
                 return mid+1;
             }
             if(nums[mid]>nums[start]){
                start = mid+1;
             }
            else{
                    end = mid;
                }
         }
        return -1;
    }
    
    public int binarySearch(int[] nums,int start, int end, int target){
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}