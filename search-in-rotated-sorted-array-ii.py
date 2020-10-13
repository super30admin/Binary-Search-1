# // Time Complexity : O(log n)
# // Space Complexity : O(1) in-place
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        # Use binary search template with some pre-probing to get end boundary
        
        # First element is target
        if reader.get(0) == target: return 0
        
        end = 1
        # Let's pick the end index as the index of a number that's > target
        while reader.get(end) < target:
            end *= 2
        
        # Pick a start index as end/2, we know our target lies within these boundaries
        start = end//2
        
        # Binary search
        while start <= end:
            mid = start + (end - start) // 2
            num = reader.get(mid)
            if num == target:
                return mid
            if target > num:
                start = mid + 1
            else:
                end = mid - 1
        return -1
                