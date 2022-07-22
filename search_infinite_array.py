# Time Complexity : O(logn) as the search space is reduced to half everytime ; where n is the no. of elements in array
# Space Complexity : O(1) ; no auxilary space needed
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        
        low = 0 # initiate low pointer as 0
        high = 1 #initiate right pointer as 1 as we don't know the value
        
        
        #while high pointer value is less than target, then move the left pointer to the right pointer position and  right pointer to twice of it's current position  
        while reader.get(high) < target:     
            low = high      
            high = high*2
            
        #now implement the binary search as we constantly know the low and high pointers     

        while low<=high: 
            mid  = low + (high-low)//2 
            mid_element = reader.get(mid) #get the middle element by API call

            if mid_element == target: 
                return mid 
            elif mid_element > target: 
                high = mid-1 
            else: 
                low  = mid+1 

        return -1
