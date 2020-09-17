# """
# // Time Complexity :O(log(N)) Since I have taken the multiplier as 2
# // Space Complexity : O(log(N)) for the call stack
# // Did this code successfully run on Leetcode : No
# // Any problem you faced while coding this : Working though edge cases


class Solution:
    
    def find_target(self, reader, target, low, high):
        # print(low, high)
        if low >= high:
            return -1
        
        val = reader.get(high)
        # print(val)
        if val == target:
            return high
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
        
        