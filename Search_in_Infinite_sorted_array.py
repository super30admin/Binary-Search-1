"""
# Time Complexity :
- O(log n), where n is the index range that includes the target

# Space Complexity :
- O(1), constant extra space

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Step 1: Find the range
        left, right = 0, 1
        while reader.get(right) < target:
            left = right
            right *= 2  # Exponentially increase the range

        # Step 2: Standard binary search
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
