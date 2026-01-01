# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        #first take double steps to find the range where the target falls
        low = 0
        high = 1

        #increasing search space by 2 is also a Binary Search
        while target > reader.get(high): #takes some m steps, stop when target is within the range
            low = high
            high = high*2

        #once we get range do simple BS
        while low <= high:
            mid = low + (high - low)//2
            
            if reader.get(mid) == target:
                return mid
            elif target < reader.get(mid):
                high = mid-1
            else:
                low = mid+1
        return -1
        
# Time Complexity is O(logm)+O(logk) k is the no of elements between low and high we do BS inside, logm is for the expansion of the range.
# Space Complexity is O(1)
# We can't take hugh strides like high*3 or high*100 because then m inc drastically and k reduces drstically. To keep a balance we take *2 which is optimal time complexity. We don't slow down once computation over the other.