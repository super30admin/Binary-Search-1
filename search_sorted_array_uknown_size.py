## Time complexity O(log N)
## Space complexity O(1)

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
	
        
        left = 0
        right = 1
        
        while reader.get(left) <= target and (not (reader.get(left) <= target and target <= reader.get(right))):
            left = right
            right = right * 2
            
        
        while left <= right:
            mid = (left + right) // 2
            
            x = reader.get(mid)
            if x == target:
                return mid
            elif x < target:
                left = mid + 1
            else:
                right = mid - 1
               
            
        return -1
            