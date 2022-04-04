# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        start = 0
        end = 1

        while(reader.get(end) <= target):
            start = end
            end = 2 * end

        while start <= end:
            mid = (start + end) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) > target:
                end = mid - 1
            else:
                start = mid + 1

        return -1
