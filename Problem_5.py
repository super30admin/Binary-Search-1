# Time Complexity : O(log n) which is binary search complexity
# Space Complexity : O(1) which is binary search complexity
# Did this code successfully run on Leetcode : Yes, with Runtime: 24 ms and Memory Usage: 13.5 MB
# Any problem you faced while coding this : Yes, I initially did with linear search and than after reading question again and
# studying came across using Binary Serach as the efficient approach to solve for sorted array.
# Your code here along with comments explaining your approach
"""
In Binary Search list is divided into two halves after calculating the middle value
and than element is searched for. In this problem since rotation is involved
so it is first checked that target=middle/pivot value if found index is returned, than
 the first half is checked if it is sorted or not
  
"""

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
          for i,val in enumerate(nums):
            if(target==val):
                return i
        return -1
        """
        first_index=0 # Initializing first index as 0
        last_index=len(nums)-1 # Initializing last_index as lenght of list-1
        while (first_index <= last_index):
            middle=(first_index+last_index)//2 # Calculating pivot/middle value
            if(target==nums[middle]):
                return middle
            
            if(nums[first_index]<=nums[middle]): # Checking whether the first half is in ascending order
                if(nums[first_index] <= target <= nums[middle]): # Implementing binary search
                    last_index=middle-1
                else:
                    first_index=middle+1
            else:
                if(nums[middle]<=target<=nums[last_index]): 
                    first_index=middle+1
                else:
                    last_index=middle-1
        return -1