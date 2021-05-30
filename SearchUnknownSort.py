#Time complexity for put and get: O(log k) where k is target
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        # expanding the boundaries logarithmically
        while reader.get(high) < target:
            low = high
            high = high * 2
        # doing bin search when boundary found. Both log k  operations
        return self.binsearch(reader,low,high,target)
        
    def binsearch(self,reader,low,high,target):
        while low<=high:
            mid = low + (high-low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1