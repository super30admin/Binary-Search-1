# Time Complexity : 
# O(log n) — we're using binary search
# Space Complexity :
#  O(1) — no extra space used
# Did this code successfully run on Leetcode : 
# Yes

# Approach
# At each step, we check whether the left or right half of the array is sorted.
# Based on where the target lies in relation to the sorted half, we eliminate half the search space.
# This ensures we keep the runtime to O(log n) by applying binary search logic even in the rotated array.


from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
    
        low, high = 0, len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid

            # Check if the left half is sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            # Right half is sorted
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
