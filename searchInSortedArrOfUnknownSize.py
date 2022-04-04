# // Time Complexity :O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        low = 0 
        high = 1
        
        
        while reader.get(high) < target:
            low = high
            high *= 2
            
            
        while low<=high:
            mid = low +(high-low)//2 
            
            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) < target:
                low = mid+1
            else:
                high = mid - 1
                
        return -1
            
        