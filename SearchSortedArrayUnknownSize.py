# Time Complexity : O(log(n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def search(self, reader, target):

        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high *= 2
        
        while low <= high:
            mid = (low + high)//2
            
            # When high goes out of bounds mid will either bring it back to bounds or mid will become infinity.
            # If middle is infinity then high will become middle-1
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                high = mid - 1
            else:
                low = mid + 1
        return -1