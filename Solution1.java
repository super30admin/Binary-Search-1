/*
    Time Complexity : O(logn)
    Space Complexity : Constant O(1)
    
    Accepted LeetCode Solution URL : https://leetcode.com/submissions/detail/632659497/

*/
class Solution1 {
    public int search(int[] nums, int target) {
        if(findPivot(nums, 0, nums.length - 1) == -1){
            return binarySearch(nums, target, 0, nums.length - 1); 
        }
        
        if(nums[findPivot(nums, 0, nums.length - 1)] == target){
            return findPivot(nums, 0, nums.length - 1);
        }
        
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, findPivot(nums, 0, nums.length - 1) - 1);
        }else{
            return binarySearch(nums, target, findPivot(nums, 0, nums.length - 1)+1, nums.length - 1);
        }
    }
    
    public int binarySearch(int[] nums, int target, int low, int high){
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(target > nums[mid]){
                low = mid + 1;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        
        return -1;
    }
    
    public int findPivot(int[] nums, int low, int high){
        if(low > high){
            return -1;
        }
        
        if(high==low){
            return low;
        }
        
        int mid = (low + high) / 2;
        
        if(mid < high && nums[mid] > nums[mid + 1]){
            return mid;
        }
        
        if(mid > low && nums[mid-1] > nums[mid]){
            return (mid - 1);
        }
        
        if(nums[low] >= nums[mid]){
            return findPivot(nums, low, mid-1);
        }else{
            return findPivot(nums, mid + 1, high);
        }
    }
}
