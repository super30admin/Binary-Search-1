# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time complexity - O(logn)
# Straight forware binary search solution on 10 power 4 sized array.
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start = 0
        end = 10 ** 4
        while start <= end:
            mid = start + (end - start)//2
            arr_val = reader.get(mid)
            # end condition 1
            if arr_val == target:
                return mid
            # decision 1 & out of bounds
            if arr_val > target:
                end = mid -1
            else:
                # if target is lower than mid
                start = mid +1
        return -1 