// time complexity - O(logn)
// space complexity - O(1)

class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                // First part of the array is sorted
                if(nums[mid]>target && nums[start]<=target){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                // Second part of the array is sorted
                if(target<=nums[end] && target>nums[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}