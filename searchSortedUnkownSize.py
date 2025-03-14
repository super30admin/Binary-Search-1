"""
#Approach:
First we are trying to expand the search boundary till we have the target in our range. 
Then we perform binary search using the range.

# Complexity
- Time complexity:
O(logn)

- Space complexity:
O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        start = 0
        end = 1
        while(reader.get(end) < target): # We are expanding the search boundary in which target is present
            start = end 
            end *= 2
            
        while (start <= end):
            mid = start + (end - start) // 2
            if (reader.get(mid) == target ): #if mid equals target returning index of mid element
                return mid
            elif(reader.get(mid) < target):
                start = mid + 1 #if target in the right side, changing the start value
            else: # else changing the end value
                end = mid -1
        return -1        