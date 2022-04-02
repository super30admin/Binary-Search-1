""" 33. Search in Rotated Sorted Array """
# Time Complexity : O(Log(N)) where N: # of elements in nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
#   Yes, Got confused on when to use '<=' or '<' 
#   L23: nums[low] <= target < nums[mid] works but
#   nums[low] <= target <= nums[mid-1] does not work (index out if bound)


class Solution:
    def search(self, nums: 'list[int]', target: int) -> int:
        if len(nums) == 0: return -1
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = int(low+(high-low)/2)
            if nums[mid] == target:
                return mid
            
            if nums[low] <= nums[mid]: # if left half is sorted  IMP (cond <=)
                if nums[low] <= target < nums[mid]: # if target in left half IMP (cond <)
                    high = mid-1
                else: # target is in right half
                    low = mid+1
            else: # right half is sorted
                if nums[mid] < target <= nums[high]: # if target in right half
                    low = mid+1
                else: # target is in left half
                    high = mid-1
        
        return -1
                    
                    
                
                
                
        
        