# // Time Complexity : O(lg n*k) where n is the length of the secret array 
# and k is the smaller search space found using two pointer apprach
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        slow = 0
        fast = 1
        # finding a search smaller search space
        # using 2 ptrs approach
        while reader.get(fast) < target:
            slow = fast
            fast *= 2

        # finding target in search space
        # using binary search 
        while slow <= fast:
            mid = slow + (fast-slow)//2
            val = reader.get(mid)
            if val == target: return mid
            elif val > target:
                fast = mid - 1
            else:
                slow = mid + 1
             
        return -1
                        