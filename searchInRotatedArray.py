class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        lo, hi = 0, len(nums)-1
        while lo <= hi:
            mid = lo + ((hi-lo)//2)
            if target == nums[mid]:
                return mid
            if target < nums[mid]:
                if (nums[lo] <= nums[mid]) and (target < nums[lo]):
                    lo = mid+1
                else:
                    hi = mid-1   
            else:
                if (nums[hi] > nums[mid]) and (target > nums[hi]):
                    hi = mid-1
                else:
                    lo = mid+1
        return -1
