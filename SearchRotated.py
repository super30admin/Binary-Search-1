# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use modified binary search. At every step, determine which half of the array and comapre with Target value.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            m = (l + h) // 2
            if nums[m] == target:
                return m
            
            # Left half is sorted
            if nums[l] <= nums[m]:
                if nums[l] <= target < nums[m]:
                    h = m - 1
                else:
                    l = m + 1
            # Right half is sorted
            else:
                if nums[m] < target <= nums[h]:
                    l = m + 1
                else:
                    h = m - 1
        
        return -1
