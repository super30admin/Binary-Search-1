''' 
Time Complexity : O(log n)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

class Solution:
    def search(self, reader, target):
        low = 0
        high = 10000
        while low <= high:
            mid = (high + low) // 2
            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1