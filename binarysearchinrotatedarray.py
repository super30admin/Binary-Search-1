# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not able to think the logic

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high-low)//2
            if target == nums[mid]:
                return mid
            # if it exists in correct order, i.e nums[low] <= nums[mid]
            if nums[low] <= nums[mid]:
                # There can be two conditions, if the target is in the sorted array from left to mid or to the right of middle
                # if the target is in between nums[low] and nums[mid], change high to mid -1
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                # else change low to mid + 1. i.e. if the target element is greater than the middle element that means it exists to right of middle.
                else:
                    low = mid + 1
                    
            # if nums[mid] is smaller than nums[low], 
            # i.e. [7,8,0,1,2] 
            # here mid = 2 and nums[mid] = 0 which is smaller than nums[low]
            else:
                # There can be two conditions, whether the target is in the sorted array from mid to high or to the left of the middle
                # If it is greater than the middle element, check from middle element + 1 to high
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                # else change the high to mid - 1
                else:
                    high = mid - 1
        return -1
nums = [4,5,6,7,0,1,2]
target = 0

obj = Solution()
print(obj.search(nums, target))
    