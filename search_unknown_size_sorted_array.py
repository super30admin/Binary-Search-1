# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code uses binary search to find the number in an array of unknown size. 
But before binary search can be run, it uses a while loop to find the appropriate range to search within.
"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start, end = 0, 1

        while reader.get(end) < target:
            start = end
            end = end * 2

        while start <= end:
            mid = (start+end)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1

        return -1