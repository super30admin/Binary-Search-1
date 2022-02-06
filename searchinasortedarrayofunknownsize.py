
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:    
    def search(self, reader: 'ArrayReader', target: int) -> int:

        if reader.get(0) == target:
            return 0

        start=0
        end=1

        while(reader.get(end) < target):
            end = end * 2
            start = end

        while (start <= end):
            mid = start + (end - start) // 2
            
            if (reader.get(mid) == target):
                return mid
            elif (target < reader.get(mid)):
                end = mid - 1
            else:
                start = mid + 1

        return -1 

# Intially see if 0th index is the target, then return 0. If not assign start as 0 and end as 1. 
# See if the target is greater than the 1st index value, if so, change end to end ^2 and start to end. And then apply normal binary search.