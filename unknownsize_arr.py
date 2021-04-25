""" Time Complexity : O(logn)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No """

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low = 0
        high = 1
        
        while reader.get(high) != 2147483647:
            if target <= reader.get(high):
                break
            else:
                low = high
                high = high*2
        
        while low <= high:
            
            mid = low + int((high-low)/2)
            ele = reader.get(mid)
            if ele == target:
                return mid
            
            elif ele < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1