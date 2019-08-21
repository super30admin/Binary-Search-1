class Solution(object):
    def search(self, nums, target):
        start = 0
        end = len(nums)-1
        while start<= end:
            mid = (start+end)//2
            if nums[mid] == target:
                return mid
            if nums[mid] <= nums[end]:
                if nums[mid] < target and nums[end] >= target:
                    start = mid + 1
                else:
                    end = mid - 1
            elif nums[mid] >= nums[start]:
                if nums[mid] > target and nums[start] <= target:
                    end = mid -1
                else:
                    start = mid + 1
        return -1