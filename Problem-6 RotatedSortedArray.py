# 33. Search in Rotated Sorted Array

# Time Complexity: O(logn)
# Space Complexity: O(1)

"""
Logic: Using Binary search reject one half of the input where the target cannot lie. 
Note: Atleast one half of a rotated sorted array in always sorted. 
"""

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        
        l = 0
        h = len(nums) - 1

        while l <= h:
            mid = (l+h)//2

            if nums[mid] == target:
                return mid
            
            if nums[l] <= nums[mid]:
                if nums[l] <= target <= nums[mid]:
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] <= target <= nums[h]:
                    l = mid + 1
                else:
                    h = mid - 1
        
        return -1