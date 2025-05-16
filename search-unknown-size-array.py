"""
This implementation uses binary search to find the target in an unknown size array.
The array is first bounded by doubling the right pointer until the target is found or the right pointer exceeds the target.
Then, binary search is performed within the bounded range to find the target.
"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader: ArrayReader, target: int) -> int:
        # First find the bounds of the array
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *= 2
            
        # Now perform binary search within the bounds
        while left <= right:
            mid = left + (right - left) // 2
            val = reader.get(mid)
            
            if val == target:
                return mid
            elif val > target:
                right = mid - 1
            else:
                left = mid + 1
                
        return -1