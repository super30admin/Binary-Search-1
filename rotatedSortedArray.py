#Time complexity O(log(n))
class Solution(object):
    def search(self, nums, target):
        high = len(nums) - 1
        low = 0
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target: 
                return mid
            if nums[low] <= nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else: 
                    high = mid - 1
        return -1