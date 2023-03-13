#Two while loops are incremented logarithmically and each of them takes O(logn) time. Total
#TC is O(logn)
#No extra space used. Space complexity = O(1)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left  = 0
        right = 1

        if(target == reader.get(right)):
            return right
        if(target == reader.get(left)):
            return left
        while(reader.get(right)<target):
            left = right
            right = right*2
        while left<=right:
            mid = (left+right)//2
            if(reader.get(mid)==target):
                return mid
            elif reader.get(mid)>target:
                right = mid-1
            else:
                left = mid+1
        return -1
        

