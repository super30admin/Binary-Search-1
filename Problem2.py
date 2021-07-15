
## Problem2
# Search in Infinite sorted array: 

# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid] == target):
                return mid
            if nums[low]<=nums[mid]:
                if nums[low]<=target<=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            elif nums[mid]<=nums[high]:
                if nums[mid]<=target<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return -1
                
                    
            
        