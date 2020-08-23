## Problem2
##Search in Infinite sorted array: 
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left,right = 0,1
        while reader.get(right) < target :
            left = right
            right*=2
            
        while left <= right:
            mid = left + (right-left)//2
            num = reader.get(mid)
            
            if num == target:
                return mid
            if num > target:
                right = mid-1
            else:
                left = mid+1
        return -1