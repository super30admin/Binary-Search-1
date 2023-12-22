"""
Time Complexity : O(log n) We are performing two operations each of log(n) time
Space Complexity : O(1) since we are not declaring anything.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = h = n = 0

        while target > reader.get(h):
            l = h                         # Since we don't know the range of array. We are trying to ascertain the
            n += 1                        #  range in log(n) time
            h = (2 ** n) - 1
            if h == (2**31) - 1:            # In this process, if we end up going out of range then we return 2^31 - 1
                return (2**31) - 1

        while l <= h:
            mid = (l+h)//2
            value = reader.get(mid)

            if value == target:
                return mid

            elif value > target:
                h = mid - 1

            else:
                l = mid + 1

        return -1


        
