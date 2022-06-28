# Time Complexity : 
#  O(log(n*m)) =  O(log n)
# Space Complexity : O(1) No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#  Imagine a flattened array as the rows and columns are sorted
# The approach to image that the array is sorted works very well
# and gives the complexity
from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        # Singlt Pass Binary search
        while low <= high:
            # This is to find mid element
            mid = low + (high - low)//2
            if target == nums[mid]:
                return mid
            # Sorted part of the array
            elif nums[low] <= nums[mid]:
                # Check if the target is present in sorted array
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                # If not target must be present in the other half
                else:
                    low = mid + 1
            # Unsorted Part of the array
            else:
    
                if target <= nums[high] and target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
s = Solution().search([4,5,6,7,0,1,2],  0)
print(s)