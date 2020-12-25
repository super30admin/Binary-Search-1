#Time complexity = O(logn) 
#space complexity= O(1) 
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : yes while trying to find a O(logn) solution, finally learnt the logn solution from sir.



# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#

#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l=0
        r=1
        nums=reader.get(r)
        while(nums<target):
            l=r+1
            r=r*2
            nums=reader.get(r)
        
        while(l<=r): #traversing through the array 
            m=(l+r)//2 #searching for the middle element
            nums=reader.get(m)
            if(nums==target): 
                return m
            elif(nums>target):
                r=m-1
            else:
                l=m+1
        return -1