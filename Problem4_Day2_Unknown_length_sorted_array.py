// Time Complexity : O(log n) where n is the index.
// Space Complexity : O(1) constant time complexity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to resolve a couple of errors with the raise exception part.


// Your code here along with comments explaining your approach: As we are restricted from finding the length, boundries were defined 
with left index as zero and right index as one. The mid-value was calculated with additional complexity to handle integer overflow 
situation. If the mid-value of index fetches the target value, the same is returned. Else, we adjust the boundaries to right or left 
depending on whether the target value is greator than or lesser than the mid-value. 

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        left, right = 0, 1
        '''For unknown length
        maxValue = 2147483647'''
        
        while left <= right:
            middle = left + (right-left) // 2   # handles integer overflow problem
            
            '''For unknown length
            if middle >= maxValue:
                raise Exception('Out of bounds')'''
                
            if reader.get(middle) == target:
                return middle
            
            if reader.get(middle) < target:
                left = middle+1
                right *= 2
                continue
            else:
                right = middle
                continue
                
        return -1
            
