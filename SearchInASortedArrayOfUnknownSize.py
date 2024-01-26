'''
First, set the j pointer by checking the high index value to set limit 
SEcondly, compute the classic binary search on the shortened section.
TC: O(logm + logn)
SC: O(1)
'''
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        i,j = 0,1
        while target > reader.get(j):
            i = j
            j = j*2
        
        while i<=j:
            mid = (i+j)//2
            v = reader.get(mid)
            if target == v:
                return mid
            if target > v:
                i = mid + 1
            else:
                j = mid - 1
        return -1