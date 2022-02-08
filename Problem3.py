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
# Time: O(n)
# Space: O(1)
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        mn = pow(2, 31) - 1
        left = 0
        right = 10000
        while left <= right:
            middle = (left+right)/2
            cur = reader.get(middle)
            if cur != mn and cur == target:
                return middle
            elif cur == mn:
                right = middle - 1
            else:
                if cur > target:
                    right = middle -1
                else:
                    left = middle + 1
        return -1
        
