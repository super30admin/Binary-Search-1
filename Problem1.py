"""
// Time Complexity : o(log n), where n  is the number of elements 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start=0
        end=len(nums)-1
        
        while start <= end: 
            
            mid = start + (end-start)//2 #finding mid
            
            if nums[mid] == target:  #if value at mid == target, return mid 
                return mid
            
            elif nums[mid] <= nums[end]: #else check if right subarray is correctly sorted 
                if target <= nums[end] and target >= nums[mid]: #check if target lies in this subarray 
                    start = mid+1 # if so, update the start variable to mid+1
                else:
                    end = mid-1 #else the value will lie in the left half, so update end = mid-1
            
            
            elif nums[mid] >= nums[start]: #else check if left subarray is correctly sorted 
                if target >= nums[start] and target<= nums[mid]: #check if target lies in this subarray 
                    end = mid-1 # if so, update the end variable to mid-1
                else:
                    start = mid+1 #else the value will lie in the right half, so update start = mid+1
            
        return -1 #if element doesn't exist