// Time Complexity : O(log n) - Binary Search
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing SPecific, implemented the solution discussed in class

//implemented a leftsearch to find first occurrence of the key and rightserach to find the last occurrence of the key
//modified binary search to check until mid-1 element is not target, so that we know mid is the target in left search
//modified binary search to check until mid+1 element is not target, so that we know mid is the target in right search



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftsearch(nums,0,nums.length-1,target);
        if(left==-1) {return new int[] {-1,-1}; }
        int right = rightsearch(nums,0,nums.length-1,target);
        return new int[] {left,right};
    }
        
        private int leftsearch(int[] nums, int low, int high, int target){
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    if(mid==low||nums[mid-1]!=target){
                        return mid;
                    }
                    high=mid-1;
                }
                else if(nums[mid]>target){
                    high=mid-1;
                }
                else low=mid+1;
            }
            return -1;
        }
        private int rightsearch(int[] nums, int low, int high, int target){
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]==target){
                    if(mid==high||nums[mid+1]!=target){
                        return mid;
                    }
                    low=mid+1;
                }
                else if(nums[mid]<target){
                    low=mid+1;
                }
                else high=mid-1;
            }
            return -1;
        }
    }
