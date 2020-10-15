# lC 702


# Given an integer array sorted in ascending order, write a function to search target in nums. 
#  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface,
#  where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

# You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.



class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        
        # init  window 
        left, right = 0, 1
        while reader.get(right) < target:  # try to find the ideal window .
            # Find a bound of start and end that contains the number
            left = right
            right =right*2
        
        # simple BS
        while left <= right:
            pivot = left + ((right - left) >> 1)
            num = reader.get(pivot)
            
            if num == target:
                return pivot
            if num > target:
                right = pivot - 1
            else:
                left = pivot + 1
                
        return -1