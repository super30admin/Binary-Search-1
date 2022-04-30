// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
/*
find which side of the array is sorted and find whether the target lies in the sorted side
based on that shift the low or high and decrease the serch space by half. there fore we can do it in log(n)

*/



class Solution {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length -1;
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            
            System.out.println(low);
            System.out.println(high);
            System.out.println(mid);
            if(nums[mid]== target) return mid;
        
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high =mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid]< target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            }
        return -1;
            
        }
        
       
    }