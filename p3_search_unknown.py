// Time Complexity : O(log N) where N is the index of the target value
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Need to work on my apporach I did not get the approach so I saw the approach and coded on my own.

class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        
        left = 0
        right = 1
        
        while reader.get(right) < target:
            left = right
            right *= 2
        
        while left <= right:
            mid = (left + right) // 2
            num = reader.get(mid)
            
            if target == num:
                return mid
            
            if target > num:
                left = mid + 1 
            else:
                right = mid - 1
                
        return -1
