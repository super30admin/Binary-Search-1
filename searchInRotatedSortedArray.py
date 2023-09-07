# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        l, h = 0, len(nums)-1
        while l <= h:
            mid = (l+h)//2
            if nums[mid] == target:
                return mid
            elif nums[l] <= nums[mid]:
                if ((nums[l] <= target) and (nums[mid] > target)):
                    h = mid - 1
                else:
                    l = mid + 1
            else:
                if ((nums[mid] < target) and (nums[h] >= target)):
                    l = mid + 1
                else:
                    h = mid - 1
        return -1
