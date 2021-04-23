"""
Intuition: Get the array limits first. Then serach it.

Find low & high. Then perform binary search on that.
#####################################################################
Time Complexity : O(log n) + O(range) where n = number of steps, range = high - low
Space Complexity : O(1)
#####################################################################

"""

class Solution:
    def search(self, reader, target):
        
        #we first obtain the left and right index of the array
        
        if reader.get(1) == 2147483647:
            return 0 if  reader.get(0) == target else -1
        
        low = 0
        high = 1
        
        #Getting the limits of the array.
        while reader.get(high) < target:
            low = high
            high = 2*high
        

        #Binary Search
        while low <= high:

            mid = (low + high) //2
            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) < target:
                low = mid + 1
                
            else:
                high = mid -1
        return -1
            