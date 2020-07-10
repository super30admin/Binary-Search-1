# Leetcode 702. Search in a Sorted Array of Unknown Size

# Time Complexity :  O(log n) for finding the range + O(log n) for implementing binary search
#   where n is the index of the target

# Space Complexity : O(1) for iterative search and O(log n) for the recursive search where n is the size of the array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use fast and slow pointers to check if target is in the range. If its not in the range move the
# slow pointer to the location of fast pointer and double the fast pointer and check. Once the target is in the range
# apply binary search on the range.

# Your code here along with comments explaining your approach

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    # Binary search iterative
    def binary_iterative(self, slow, fast, target, reader):

        while slow <= fast:
            mid = slow + ((fast - slow)//2)
            if reader.get(mid) == target:
                return mid

            if reader.get(mid) > target:
                fast = mid-1
            else:
                slow = mid + 1

        return -1

    # Binary search recursive
    def binary_recur(self, slow, fast, target, reader):

        while slow <= fast:
            mid = slow + ((fast - slow)//2)
            if reader.get(mid) == target:
                return mid

            if reader.get(mid) > target:
                return self.binary_recur(slow, mid-1, target, reader)
            else:
                return self.binary_recur(mid+1, fast, target, reader)
        return -1

    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # initializing slow and fast pointer
        slow = 0
        fast = 1

        # Updating slow and fast pointer until the range is found
        while (reader.get(fast) < target):
            slow = fast
            fast = fast*2

        # return self.binary_iterative(slow,fast,target,reader)
        return self.binary_recur(slow, fast, target, reader)
