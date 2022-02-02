# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Initial search bounds
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            # Calculate mid index for the present search bounds
            mid = (lo + hi) // 2
            # If target found at mid index, return the mid index
            if nums[mid] == target:
                return mid
            # If element at mid index is greater than target
            elif nums[mid] > target:
                # If element at mid index is greater than or equal to element at lo and target is less than element at lo, then search in the right part of the array
                if nums[mid] >= nums[lo] and target < nums[lo]:
                    lo = mid + 1
                # Else search in the left part of the array
                else:
                    hi = mid - 1
            # If element at mid index is smaller than target
            else:
                # If element at mid index is smaller than or equal to element at hi and target is greater than element at hi, then search in the left part of the array
                if nums[mid] <= nums[hi] and target > nums[hi]:
                    hi = mid - 1
                # Else search in the right part of the array
                else:
                    lo = mid + 1
        # Return -1 if target is not found
        return -1