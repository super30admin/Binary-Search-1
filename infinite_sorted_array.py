// Time Complexity : O(log n) where n is the number of all elements in 2d array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// As we dont know the length of array, we loop through the high pointer until we reach array out of bound. Once we have
// the high pointer i.e. the position of last element of array, we perform normal binary serach on the array.


class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        high=1
        
        while(reader.get(high)!= 2147483647):
            high *= 2
        
        return(self.binary_search(reader, target, 0 , high))
    
    def binary_search(self,reader,target,low,high):
        
        while(low <= high):
            mid = low + (high - low)//2
            
            if(reader.get(mid) == target):
                return(mid)
            
            elif(reader.get(mid) <target):
                low = mid + 1
            else:
                high = mid - 1
        
        return(-1)
         