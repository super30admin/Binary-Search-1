# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        #need to determine the right limit first
        left, right = 0, 1 #10000
        while True:
            cur = reader.get(right)
            if cur < target:
                left = right
                right <<= 1  
            else:
                break

        while left <= right:
            mid = (left+ right)//2
            cur = reader.get(mid)
    
        
            if cur == target:
                return mid
            
            if cur > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1
