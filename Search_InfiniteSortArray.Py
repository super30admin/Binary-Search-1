# // Time Complexity : O(log N)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


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
                
            
       
    
        