# """
# // Time Complexity :O(log(T)) Index of the target value
# // Space Complexity : O(log(T)) for the call stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Working though edge cases and the stopping condition. Git it fixed through a hack

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    
    def find_target(self, reader, target, low, high):

        
        val = reader.get(high)
        if val == target:
            return high
        
        if low >= high:
            return -1
        elif val == self.invalid_output or val > target:
            mid = low + (high - low) // 2
              
            return self.find_target(reader, target, low, mid)

        else:
            return self.find_target(reader, target, high, high * self.multiplier)
        
    
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        self.invalid_output = 2147483647
        
        self.multiplier = 2

        
        return self.find_target(reader, target, 0, self.multiplier)
        
        
        