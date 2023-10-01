class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        """
        Time Complexity: O(log(n))
        Space Complexity: O(1)
        Did this code successfully run on Leetcode: Yes 
        Any problem you faced while coding this:

        I had to refer to the logic taught in the class

        Your code here along with comments explaining your approach:
        The approach: 
            -> first find whether the target lies between low and high
            -> if not put the low pointer to high and double the high pointer
            -> once you find the range apply normal binary search to find whether 
            the target lies between low and high
        """

        low = 0 
        high = 1
        while (reader.get(high) <= target):
            low = high
            high = 2*high
        while (low <= high):
            mid = int(low + (high - low)/2)
            if (target == reader.get(mid)):
                return mid
            elif (target < reader.get(mid)):
                high = mid - 1
            else:
                low = mid + 1
        return -1