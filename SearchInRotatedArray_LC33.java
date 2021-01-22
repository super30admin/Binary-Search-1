/*
Time Complexity: O(log n)
Space Complexity: O(1)
1) Start BS
2) find mid pt return if target
3) check if left is sorted: adjust start/end if target lies within left range
4) check if right is sorted: adjust start/end if target lies within right range

*/

class Solution {
    public int search(int[] nums, int target) {
        
        if(nums == null) return -1;
        int end = nums.length - 1;
        int start = 0;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
                return mid;
            
            //check if left is sorted
            else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
                
            }
            else{
                if(target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}