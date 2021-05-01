# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Solution:
"""
1. Initialize the range from 0 to 1 and check if the target is greater than the higher bound value.
2. If so, keep changing the range starting from higher bound to twice of the higher bound.
3. After getting valid boundaries, perform binary search on that range and return the index of the target.
"""

class Solution:
    def search(self, reader, target):
        low = 0
        high = 1

        # Search boundaries
        while target > reader.get(high):
            low = high
            high *= 2

        # Binary search
        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if target == val:
                return mid
            elif target < val:
                high = mid - 1
            else:
                low = mid + 1

        # No target element
        return -1
