# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
    
    
        # O(log n)
        left = 0
        right = 1
        
        # firstly we decide our boundaries for search
        while reader.get(right) < target:
            left = right
            right *=2
            
            
        # now we run our normal binary search
        
        while left<=right :
            mid = (left+right)//2
            
            if target == reader.get(mid):
                return mid
            
            if target<reader.get(mid):
                right = mid-1
            elif target > reader.get(mid): 
                left = mid+1
                
        return -1
                
            