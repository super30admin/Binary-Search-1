#  Time Complexity : O(logm) where m is the range of the high pointer  
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach in three sentences only: Get the value at the high pointer and check if its value is lesser than the target. If the value is lesser move the low pointer to the high pointer and move the high pointer at a rate of high = high * 2. Once we find the correct range we just use binary search to find the target element. 

class Solution:
    def search(self, reader, target):
        low, high = 0, 1
        while reader.get(high) < target:
            low = high
            high *= 2
        return self.binary_search(reader, target, low, high)
    
    def binary_search(self, reader, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)
            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1