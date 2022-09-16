"""
 FAANMG Problem #7 {Easy}

Problem 3
702. Search in a Sorted Array of Unknown Size

Time Complexity : O(logN)
 
Space Complexity : O(1)

    
We are trying to move the search space in a way that 
low is moved 1st step
High with 2*High
Loop Until we find the target greated than high element position

Then Mid is found and applying Binary Search

    
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        
        low = 0
        high = 1
        
        while reader.get(high) < target:
            low = high
            high *= 2
        
        while low <= high:
            mid = (low + high)//2
            
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
        