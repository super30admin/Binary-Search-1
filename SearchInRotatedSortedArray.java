//Exercise_6 : Search in a Rotated Sorted Array
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
//Note : As in this case there will be two sorted arrays, so we have to partition them and then implement the binary search. To find the partition, minimum element index is to be find so that binary search can be implemented further for finding the target using (start to minIndx-1) and then if target element is not found implment binary search from (minIndx to end); 


/**** Steps ****/
/*
  1) For Finding Minimum Element Index
       a) Find mid. Then find next index and the previous index because if mid is smaller than or equal to its neighboring elements it means mid is the minimum element. Here nextIdx = (mid+1)%N; %N is implemented because there could be a case when mid is the last element. Further (mid-1+N)%N; because mid could be the first element and mid -1 will return negative value i.e N will be added to it. 
       While comparision equal to is also used because there could be a case when there will be single element.
       b) Check if left part is sorted means if arr[start]<= arr[mid] then search the minimum on the right side otherwise search for the minimum on the left side
       c) Before finding the mid do check if arr[start]<arr[end] because there could be a case when the partition or the whole array is sorted in ascending order, then just return the start as the minimum index.

  2) Once the minimum index is found, implement the binary search for finding the index of the target from indices from 0 to minIndx-1. If element not found in this search, implement the binary search for finding the index of the target from indices from minIndx to end.       
*/


class Solution6 {
    public int search(int[] nums, int target) {
        
        int end   =nums.length-1;
        
        int minIdx = findMinIndx(nums);
        
        int res = -1;
        
        res = binarySearch(nums,target,0,minIdx-1);
        
        if(res==-1){
            res = binarySearch(nums,target,minIdx,end);
        }
        
        return res;
    }
    
    private int findMinIndx(int[] nums){
        
        int start = 0;
        int N = nums.length;
        int end   = N-1;
        
        while(start<=end){
            
            if(nums[start]<nums[end]){
                return start;
            }
            
            int mid = start+(end-start)/2;
            int nextIdx = (mid+1)%N;
            int prevIdx = (mid-1+N)%N;
            
            if(nums[mid]<=nums[prevIdx] && nums[mid]<=nums[nextIdx]){
                return mid;
            }else if(nums[start]<=nums[mid]){
                start = mid+1;
            }else if(nums[mid]<=nums[end]){
                end = mid-1;
            }
            
        }
        
        return -1;
    }
    
    private int binarySearch(int[] nums, int target, int start, int end){
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(target == nums[mid]){
                return mid;
            }else if(target<nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
            
        }
        return -1;
    }
    
    
}