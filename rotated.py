##Search in Rotated Sorted Array
// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if (nums == 0 or len(nums) == 0): ##edge case
            return -1;
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high-low) // 2
            if (nums[mid] == target):#base condition
                return mid
            elif (nums[low] <= nums[mid]):
                #left sorted
                if (target >= nums[low]  and target < nums[mid]):
                    high = mid -1
                else:
                    low = mid + 1
            else:
                #right sorted
                if (target > nums[mid] and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        
        
        return -1
                    
                    
                
                
                    
                
            
            
        
