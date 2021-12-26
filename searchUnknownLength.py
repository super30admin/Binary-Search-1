# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        # Find the upper limit where we can use as the high pointer.
        while reader.get(high) < target:
            high = high * 2

        # Apply binary search as we have got the low and high values now.
        while low <= high:
            mid = (low+high)//2
            val = reader.get(mid)
            if val == target:
                return mid
            if val > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1