# Design Hashmap (https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/)
# Time complexity: O(log(n)); n=no of elements in array 
# Space complexity: O(1); 
# Did this code successfully run on Leetcode : Yes
# Approach: Binary search

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if len(nums) == 0:
            return -1
            
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                return mid
            
            # Decide which half is sorted and do bSearch on that half
            # Left half is sorted
            elif nums[mid] >= nums[low]:
                if nums[low] <= target and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
            # Right half is sorted
            else:
                if nums[mid] < target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
                
                
                
                
        
                
        