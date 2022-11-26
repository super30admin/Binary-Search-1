<<<<<<< HEAD
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
=======
# // Time Complexity : O(log(n))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only

class Solution:
        def search(self, reader, target):

            low = 0
            high =1
            ## we keep increasing the size of our search space 
            ## Important point: binary search is when we either decrease the search speace or increase the search
            ## space
            while target >= reader.get(high):
                low = high
                high = 2 * high

            while low < high:
                mid = low + (high-low)//2
                if target == reader.get(mid):
                    return mid
                
                if target >= reader.get(low) and target < reader.get(mid):
                    high = mid-1
                
                else:
                    low = mid+1
            return -1
                    

                    
>>>>>>> b95867a (Completed Binary Search-1)
