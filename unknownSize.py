# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        r = 9999
        while l<=r:
            mid = (l+r)//2
            if target == reader.get(mid):
                return mid
            elif target > reader.get(mid):
                l = mid+1
            else:
                r = mid-1
        return -1
         