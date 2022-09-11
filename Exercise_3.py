# Time Complexity: O(logn)
# Space Complexity: O(1)
# Any problem you faced while coding this : No
# Did this code successfully run on Leetcode: Yes

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
        if reader.get(0) == sys.maxint:
            return -1
        
        low = 0
        high = 1
        
        while reader.get(high)<target:
            low = high
            high = high * 2
            
        while low<=high:
            mid = low + (high - low)/2
            element = reader.get(mid)
            if element == target:
                return mid
            if target<element:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    