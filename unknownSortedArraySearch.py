'''
Time Complexity -->
O(n/2) + O(logn) --> n/2 since the loop will half the time to find l and h and logn for binary search

Space Complexity
O(1) 

Approach-->
1. get the range low and high by hitting the API 
2. loop through the array until ArrayReader.get(high)<target
3. Once we get the range perform binary search and find the target element

'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l = 0
        h = 1
        while reader.get(h)<target:
            l = h
            h = h*2 #Increement value of head twice
        #Once we get the range we can now perform binary Search
        while l<=h:
            mid = (l+h)//2
            if target == reader.get(mid):
                return mid
            elif target>reader.get(mid):
                l = mid+1
            else:
                h = mid-1
        return -1
                
        
        
        