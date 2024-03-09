# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# class Solution:
#     def _binary_search(self, reader, low, high, target) -> None:
#         while(low<=high):
#             mid = low + (high-low)//2
#             if reader.get(mid) == target:
#                 return mid
#             if target<reader.get(mid):
#                 high = mid-1
#             else:
#                 low = mid+1
#         return -1
#     def search(self, reader: 'ArrayReader', target: int) -> int:
#         low, high = 0, 1
#         while(low<=high):
#             if target>=reader.get(low) and target<reader.get(high):
#                 return self._binary_search(reader, low, high, target)
#             else:
#                 low, high = high, high*2
#                 if reader.get(low) == 2^32-1 and reader.get(high) == 2^31-1:
#                     break
#         return -1
"""TC: O(logm) + O(logn) where first term is for finding the range and second term is for
doing binary search in that found range
SC: O(1)"""
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        i,j = 0,1
        while (reader.get(j)<target):
            i=j
            j=j*2
        while i<=j:
            mid = (i+j)//2
            mid_val = reader.get(mid)
            if mid_val == target:
                return mid
            elif target > mid_val:
                i = mid + 1
            else:
                j = mid - 1
        return -1