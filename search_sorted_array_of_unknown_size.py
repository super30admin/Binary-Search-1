#Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

#working mechanism: since we do not known the length of the secret array, where to put the high pointer is the question and we have set it to max value but that will solve th eproblem in log infinity time and we desire log n, so we first find the search space and then implement the binary search in the selected search space to find inddex of target, if found we return the index, else we return -1. to find the search space we use binary increment of high pointer like high will be initialized to 1 and then based on the target reach, we increase the search space by doubling the high pointer. and we apply binary search in the selected search space.

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = high * 2
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target: return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1