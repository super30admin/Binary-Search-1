# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Remembering to expand search window before binary search


# Your code here along with comments explaining your approach in three sentences only
# First, expand the right boundary exponentially until the target is within range.
# Then, perform a normal binary search between left and right.
# This ensures efficiency even if the array is very large.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0   # left boundary
        r = 1   # start with a small right boundary

        # Expand the search range until target is within it
        while reader.get(r) < target:
            l = r   # move left boundary to current right
            r = r * 2   # double right boundary
        # Standard binary search in the found range
        while l <= r:
            mid = (l + r) // 2

            if reader.get(mid) == target:   # found target
                return mid

            if reader.get(mid) > target:
                r = mid - 1 # target lies in left half

            else:
                l = mid + 1 # target lies in right half
        return -1

