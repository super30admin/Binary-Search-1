class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while (start <= end):
            mid = start + (end - start) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[start]:
                if nums[mid] > target and target >= nums[start]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                if target <= nums[end] and target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1

    # Runtime: 32
    # ms, faster
    # than
    # 30.56 % of
    # Python
    # online
    # submissions
    # for Search in Rotated Sorted Array.
    # Memory
    # Usage: 13.9
    # MB, less
    # than
    # 14.81 % of
    # Python
    # online
    # submissions
    # for Search in Rotated Sorted Array.