# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation(

'''
TC: O(logn)
SC: O(1)
Intuition: Reverse Binary Search - bottom-up.
'''

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
        start, end = 0, 1
        ar = reader

        while start <= end:
            mid = start + (end - start) // 2
            midval = ar.get(mid)
            if target == midval:
                return mid
            if target < midval:
                end = mid - 1
            elif ar.get(start) > target:
                return -1
            else:
                start = mid + 1
                end *= 2
        
        return -1