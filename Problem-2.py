# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        left = 0  # Initialize left pointer
        right = len(nums) - 1  # Initialize right pointer (last index)
        
        while left <= right:
            mid = (left + right) // 2  # Calculate mid index
            
            if nums[mid] == target:  # Check if the mid element matches the target, return index
                return mid
            
            # Check if the left half is sorted
            if nums[left] <= nums[mid]:
                # If target lies within the left sorted half
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # Right half is sorted
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
                    
        # Target not found
        return -1
