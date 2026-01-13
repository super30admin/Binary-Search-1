# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use binary search with additional logic to handle rotation.
# First identify which half is sorted by comparing mid with left boundary.
# Then check if target lies in the sorted half, otherwise search in the other half.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] == target:
                return mid
            
            # Check if left half is sorted
            if nums[left] <= nums[mid]:
                # Target is in the left sorted half
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # Right half is sorted
                # Target is in the right sorted half
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return -1

