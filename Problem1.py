## Problem1 
##Search in a Rotated Sorted Array

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums)==0: return -1
        
        left, right = 0, len(nums)-1 
        while left<=right:
            mid = left+(right-left)//2
            if nums[mid] == target:
                return mid
            elif nums[left] <= nums[mid]:
                if nums[left]<=target<nums[mid]:           
                    right = mid-1
                else:
                    left = mid+1
            else:
                if target > nums[mid] and target<=nums[right]:
                    left = mid + 1
                else:
                    right = mid-1            
        return -1