# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

# Time Complexity: O(log n)
# Space Complexity: O(1)

# Logic: set an initial range & find whether target is within the range or not. If not then double the range
# finally when we have the range, search for the target element if present return index else return -1

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start = 0
        end = 1

        while reader.get(end) <=  target and reader.get(end) < (2**31)-1:
            start = end
            end = 2*end
        
        while start <= end:
            mid = (start+end)//2

            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1
