#Time Complexity: O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        left = 0
        right = pow(10,4)+1                             #Since it is given that the max size can be 10^4
        
        while left <= right:                            #Following basic Binary Search
            mid = left + (right - left) // 2
            val=reader.get(mid)                         #Given interface method to retrieve the value
            
            if val == target:
                return mid
            elif val < target:
                left = mid + 1
            elif val == 2147483647 or val > target:     #Additional optional condition to check if the index exists or if the target is more than number
                right = mid - 1
        return -1
