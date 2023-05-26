'''
Time Complexity : O(log n), where n is index of target
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, in calculating time complexity
Your code here along with comments explaining your approach:
        check indexes as power of 2
        if target is less than the index, then apply binary search
        between current index and previous index.
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def binary(self,reader, left, right, target):
        while left<= right:
            mid = (right+left)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) < target:
                left = mid+1
            else:
                right = mid-1
        return -1

    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0)==target:
            return 0

        for i in range(15):
            pivot = 2**i
            if reader.get(pivot) == target:
                return pivot
            elif reader.get(pivot) < target:
                continue
            else:
                if i>=1:
                    left = 2**(i-1)
                else:
                    left = 0
                right = pivot
                return self.binary(reader, left, right, target)
        
        return -1

