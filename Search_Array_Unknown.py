# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved ans submitted

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        # Fetching the first value from the Array reader and check if it is the target, if yes then return the index 0
        if reader.get(0) == target:
            return 0
        
        # taking left and right as 0,1 as we do not know the size of the array
        left, right = 0,1
        
        # we will fetch the values until the right index reached more than target
        # switching the values of right to left, and increase the value of right 2 times
        while reader.get(right) < target:
            left = right
            right = right * 2
        
        # After finding the index which is more than the target, we can do binary search as we have the 
        # left and right index
        while left <= right:
            mid = left + (right - left) // 2
            
            # fetch the value of the mid, check for target, if not then change the pointers low and high to find the value
            num = reader.get(mid)
            if num == target:
                return mid
            if num > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return -1
