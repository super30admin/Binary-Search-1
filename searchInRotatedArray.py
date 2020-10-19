class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0 
        end = len(nums)-1
        while start <= end:
            mid = (start + end)/2
            if nums[mid] == target:
                return mid
            if nums[start] <= nums[mid]:
                if target >= nums [start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid -1
        return -1