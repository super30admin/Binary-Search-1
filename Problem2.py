# Time Complexity : O(2 log n) -> O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : I was not able to test it in LeetCode because of the premium
# Any problem you faced while coding this : No I was able to code easily


# Your code here along with comments explaining your approach in three sentences only



# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class ArrayReader:
    def __init__(self, secret):
        self.secret = secret
    
    def get(self, index: int) -> int:
        # Returns INT_MAX if index is out of bounds
        if index < 0 or index >= len(self.secret):
            return 2**31 - 1
        return self.secret[index]


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        low = 0
        high = 1

        while True:
            if target <= reader.get(high):
                break
            low = high
            high = high * 2
        
        while low < high:
            mid = low + (high - low)//2
            if reader.get(mid) == target:
                return mid
            elif  target < reader.get(mid):
                high = mid - 1
            else:
                low = mid + 1
        
        if  reader.get(low) == target:
                return low
        else:
            return -1


# Example usage:
secret = [-10, -3, 0, 5, 9, 12, 17, 20]
reader = ArrayReader(secret)

sol = Solution()
target = 12
print(sol.search(reader, target))  # Should print 5 (index of 12)