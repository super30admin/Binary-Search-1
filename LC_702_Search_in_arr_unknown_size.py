# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

# TC = O(N) move N times for getting range of Low and High. Then Log(N) for binary search => N + log(N) => o(N)
# SC = O(1), no extra Data Structure

class Solution:
    def search(self, reader, target):
        low, high = 0, 1 
        
        while(reader.get(high) < target):
            
            low = high
            high = 2*high
            
        while(low <= high):
            mid = int(low + (high-low)/2)
            mid_num = reader.get(mid)

            if(mid_num == target):
                return mid
            if(target > mid_num):
                low = mid+1
            elif(target < mid_num ):
                high = mid-1
       
        return -1

    