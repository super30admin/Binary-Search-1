#time Complexity O(1)

class Solution(object):
    def search(self, nums, target):
        l = 0
        r = len(nums)-1
        while l <= r:
            mid = l + (r-l)/2
            if nums[mid] == target:
                return mid
            if nums[mid] < nums[r]:
                if nums[mid] < target and nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid -1

            else:
                if nums[l] <= target and nums[mid] > target:
                    r = mid -1
                else:
                    l = mid + 1
        return -1

        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
