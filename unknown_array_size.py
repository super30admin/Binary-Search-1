"""
Time Complexity: O(n + logn)
Space Complexity: O(1)
Did your code run on leetcode?: yes
Issues Faced: calling the API interface
"""

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
        l = 0
        h = 1
        while(reader.get(h)!= float('inf') and reader.get(h) <= target):
            h = h*2
            
        while(l<=h):
            mid = l + (h-l)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                h = mid -1
            elif reader.get(mid) < target:
                l = mid +1
        return -1