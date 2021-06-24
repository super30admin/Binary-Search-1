# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def search(self, reader, target):
        low = 0
        high = 1
        while (reader.get(high) < target):
            low = high
            high = high * 2
        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader, target, low, high):

        while (low <= high):
            mid = low + (high - low) // 2

            if (reader.get(mid) == target):
                return mid
            elif (reader.get(mid) > target):
                high = mid - 1
            else:
                low = mid + 1
        return -1
