# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
          
        left = 0
        right=1
        
        while reader.get(right)<target:
            left =right
            right =2*right
            
        
        while left<=right:
            mid =(left + right)//2
            if reader.get(mid)==target:
                return mid
            if reader.get(mid)>target:
                right = mid-1
            else:
                left = mid  + 1
                
           
        
        return -1
        
