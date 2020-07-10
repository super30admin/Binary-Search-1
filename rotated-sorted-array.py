# Time Complexity : O(log(n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We will use binary search. We know that from the mid point of the array, either of the left or the right part of the array has to be sorted.
#2. If the left part of the array is sorted, we apply binary search in there, to find the element in the left subpart of the array, or same for right sub array. 

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums)-1
        while left <= right:
            mid = left + (right - left)/2
            
            if nums[mid] == target: return mid
            if nums[mid] <= nums[right]:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            elif nums[left] <= nums[mid]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else: left = mid + 1
        return -1
