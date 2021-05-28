# // Time Complexity : O(log(n))
# // Space Complexity : O(logn)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        #Exponentially calculate high till it is greater than equal to target
        high = 1
        while reader.get(high) <= target:
            high = high << 1
        low = high >> 1
        # Normal binary search
        while (low <= high):
            mid = int(low + (high - low) / 2)
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1