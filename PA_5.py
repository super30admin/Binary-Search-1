#Leetcode 33 : Search in Rotated Sorted Array
#Time Complexity : O(logn)
#Space Complexity : O(1)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return -1 
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = (start + end) // 2
            #print(start,mid,end)
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[start]:
                if nums[start] <= target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if nums[mid] < target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        
        return -1