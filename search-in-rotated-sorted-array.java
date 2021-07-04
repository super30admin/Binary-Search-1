/*

Did it run on leetcode: yes
Time Complexity: 0(LogN)
Space Complexity: 0(1)

Algorithm:
- We try to check mid  value if that is the target.
- If its not, then atleast the right or the left part will be sorted in rotated array
 to decide our window.



*/



class Solution {
    public int search(int[] nums, int target) {
     
        int low=0,high=nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                return mid;
            }
            
            else if(nums[low]<=nums[mid]){
                if(target<=nums[mid+1] && target>=nums[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[high] >= target && nums[mid] <= target) low= mid +1;
                else high = mid - 1;
            }
        }
        
        return -1;
    }
}