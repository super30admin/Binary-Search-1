# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        #search the 1st occurence of the array out of bound index to get the length 
        #of the arrya, then normal binary search in sorted array
        left = 0
        right = 1
        valAtRight = reader.get(right)
        while target >= valAtRight:
            if valAtRight == target:
                return right
            left  = right
            right = right*2
            valAtRight = reader.get(right)

        while left <= right:
            mid = left + (right-left)//2
            val = reader.get(mid)
            if val == target:
                return mid
            
            if target > val:
                left = mid+1
            else:
                right = mid -1
        
        return -1
