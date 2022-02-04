# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:    
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        # if target found at start index
        if reader.get(0) == target:
            return 0
        
        start=0
        end=1
        
        # to get the start and end pointers
        while(reader.get(end) < target):
            end = end * 2
            start = end
            
        # normal binary search with the found start and end
        while (start <= end):
            mid = start + (end - start) // 2
            if (reader.get(mid) == target):
                return mid
            elif (target < reader.get(mid)):
                end = mid - 1
            else:
                start = mid + 1
                
        return -1