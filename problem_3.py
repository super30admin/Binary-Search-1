# Time Complexity : O(log*n) + O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# first get the range where target lies
# to get the range define two pointers start = 0 and end = start + 1
# until end pointer is >= target shift start to end index and end index to end * 2 th index
# now we get the start and end values indices
# then do normal binary search

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target: int) -> int:
        start = 0
        end = start + 1
        while reader.get(end) < target:
            start = end
            end = end * 2
        while start <= end:
            mid = start + (end - start) // 2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1
