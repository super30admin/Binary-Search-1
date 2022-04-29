#Time Complexity: O(log m + log n) = O(log mn)
#Space Complexity: O(1) no auxilary space used
#Did your code executed on leetcode: yes it did
#Issues encountered : To figure out how to find high in binary search

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low,high = 0,1
        
        #to find the range
        while(reader.get(high) <= target):
            low = high
            high = 2*high
        
        #after finding the range performing binary search on that particular range to find target value index
        while (low <= high):
            mid = low + (high-low)//2
            
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid -1
            else:
                low = mid + 1
        return -1
                
            
        
