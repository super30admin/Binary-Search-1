// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def search(self, array, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1
        
        while reader.get(high)<=target:
            low = high
            high = high*2
        
        while low<=high:
            mid = (low+high)//2
            if reader.get(mid) == target:
                return mid
            elif target >reader.get(mid):
                low = mid+1
            else:
                high = mid-1
        return -1
        

######## Second Approach ############
// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution:
    def search(self, array, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = target-reader.get(low) # Taking the difference of target value and first element as there are no duplicates target should be in this range
        
        while low<=high:
            mid = (low+high)//2
            if reader.get(mid) == target:
                return mid
            elif target >reader.get(mid):
                low = mid+1
            else:
                high = mid-1
        return -1