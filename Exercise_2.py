# ## Problem2
# Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# // Time Complexity : O(logm + logn) = O(logmn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def search(self, reader, target):
        # defining 2 ptrs low
        low = 0
        # and high
        high = 1
        # till target comes in range
        while (reader.get(high) < target):
            # low to high
            low = high
            # increasing range by 2 times
            high = 2 * high
        # binary search
        while (low <= high):
            # calculating mid
            mid = (low + high)//2
            # if mid has target
            if reader.get(mid) == target:
                # target in the array
                return mid
            # left part of the array
            elif target >= reader.get(low) and target < reader.get(mid):
                # updating high - shortening search by 1/2
                high = mid - 1
            else:
                # updating low - shortening search by 1/2
                low = mid + 1
        return -1
