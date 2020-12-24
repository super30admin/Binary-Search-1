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
        
        left, right = 0, 1
        
        while reader.get(right) < 100000 and reader.get(right) < target:
            left = right
            right = right * 2
            
        while(left <= right):
            
            mid = (left + right) // 2
            
            if reader.get(mid) == target:
                
                return mid
            
            else:
                
                if reader.get(mid) < target:
                    
                    left = mid + 1
                    
                else:
                    
                    right = mid - 1
                    
        return -1
            
        
