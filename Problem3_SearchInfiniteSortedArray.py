# Time Complexity : O(log n) where n is the position of target
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: First find the search boundaries by exponentially expanding the range.
# Once boundaries are found, perform standard binary search within those bounds.
# Handle IndexError when accessing elements beyond array length.

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # First, find the boundaries
        left = 0
        right = 1
        
        # Expand right boundary until we find a range that contains target
        # or until we go out of bounds
        while reader.get(right) < target:
            left = right
            right = right * 2
        
        # Now perform binary search within the found boundaries
        while left <= right:
            mid = left + (right - left) // 2
            try:
                mid_value = reader.get(mid)
            except IndexError:
                # If we go out of bounds, adjust right boundary
                right = mid - 1
                continue
            
            if mid_value == target:
                return mid
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return -1

