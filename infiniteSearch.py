# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # If the first elem is target
        if reader.get(0) == target:
            return 0
        # Initialize start and end
        start = 0
        end = 1
        # Finding an end
        while reader.get(end) <= target:
            start = end
            end = end << 1
        # Regular Binary Search
        while start <= end:
            mid = (start + end) // 2
            cur = reader.get(mid)
            if cur == target:
                return mid
            elif cur > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1
