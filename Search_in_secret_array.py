# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

"""
Time Complexity:
O(log(n))
"""

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l = 0
        r = 10**4
            
        
        while l <= r:
            mid = int((l + r)/2)
            if reader.get(mid) == (2**31) - 1:
                r = mid - 1
                
            elif reader.get(mid) != (2**31) - 1:
                if reader.get(mid) == target:
                    return mid
                elif reader.get(mid) < target :
                    l = mid + 1
                else:
                    r = mid - 1
        return -1