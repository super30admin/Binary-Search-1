#Time Complexity :  O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        
        
        """
        
        
        low = 0
        high= 1
        
        if reader.get(0)==target:
            return 0
        while reader.get(high) < target:
            low = high
            high <<=1             # first seeting the boundaries then apply binary search
        
        while low <= high:
            mid = low+(high-low)//2
            num = reader.get(mid)
            
            if num == target:
                return mid
            elif target< num:
                high = mid-1
            else:
                low = mid+1
        return -1