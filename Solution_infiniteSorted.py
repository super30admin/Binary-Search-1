"""
 Suppose you are given a sorted array of unknown length and a number to search for, return the index of the number. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1. 
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

  
// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : I couldn't check as it is premium 
// Any problem you faced while coding this : Intution took time 


// Your code here along with comments explaining your approach

"""

class Solution_infiniteSorted:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        
        start high index 1 and muliply them *2 when target is not found.
        set low to high/2
        do binary search 
        
        """
        high=1
        while(ArrayReader.get(high)<target):
        	high=high*2
        low=int(high/2)

        while low<=high:
        	mid=low+(high-low)//2
        	if(ArrayReader.get(mid)==target):
        		return mid

        	if(ArrayReader.get(mid)>target):
        		high=mid-1
        	else:
        		low=mid+1


        return -1
