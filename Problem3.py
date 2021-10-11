# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:


#Leetcode 702:Search in a Sorted Array of Unknown Size

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start = 0
        fast = 1
        
        while( reader.get(fast) < target and reader.get(fast) < (2**31)-1):
            
            start = fast
            fast = fast*2
        
        while(start <= fast):
            
            mid = (start + fast)//2
            
            if reader.get(mid) == target:
                return mid
            
            
            if target > reader.get(mid):
                start = mid+1
            else:
                fast = mid-1
        
        return -1