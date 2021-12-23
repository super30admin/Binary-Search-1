# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    '''
    This solution has two major steps. Increasing search space till we find the correct bounds.
    Implementing binary search on the new bounds.
    '''
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        left = 0
        right = 1
        exception = 2 ** 31 - 1
        
        while reader.get(right) <= target:
            if reader.get(right) == target:
                return right
            right *= 2
        
        while left <= right:
            pivot = left + (right - left) // 2
            curr = reader.get(pivot) 
            if curr == target:
                return pivot
            if target < curr:
                right = pivot - 1
            else:
                left = pivot + 1
        
        
        return -1