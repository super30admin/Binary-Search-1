# Time Complexity : O(log(n)) where n is the size of the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use the property of rotated sorted arrays which states that when we take the midpoint, 
# atleast one side of the array is always sorted.
# We use this to confirm whether it is present in the sorted side, if not then recurse onto the other half.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        l, h = 0, len(nums)-1

        while l <= h:
            m = l + (h-l)//2
            if nums[m] == target:
                return m
            elif nums[l] <= nums[m]:
                if nums[l] <= target <= nums[m]:
                    h = m - 1
                else:
                    l = m + 1
            else:
                if nums[m] <= nums[h] and nums[m] <= target <= nums[h]:
                    l = m + 1
                else:
                    h = m - 1
        return -1


