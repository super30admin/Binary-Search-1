import math

"""
Time complexity - O(log(n))
"""


class Solution:
    
    
    def binarySearch(self, nums, start, end, target):
        mid = math.floor((start + end)/2)
        print(" start ", start)
        print(" start ", start)
        
        if nums[mid] == target:
            return mid
        if start < end:
            if nums[mid] > target:
                # target can present in right half of the array when 
                # if target is involved in array rotation.
                if nums[mid] > nums[end] and nums[end] >= target:
                    start = mid+1
                else:
                    end = mid-1
            else:
                # target can present in left half of the array when 
                # if target is involved in array rotation.
                if nums[start] > nums[mid] and nums[start] <= target:
                    end = mid-1
                else:
                    start = mid+1
            return self.binarySearch(nums, start, end, target)
        return -1
            
            
            
    def search(self, nums: List[int], target: int) -> int:
        return self.binarySearch(nums, 0, len(nums)-1, target)
 
        
        