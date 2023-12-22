"""
    Approach
    1. find whether middle belong to left sort or right sorted portion
        if middle > left -> this says middle is left sorted portion
        else:
            right sorted portion
    2. next up 
        find target value belongs to left or right portion
        if target > middle -> its right portion l = m+1
        if target < leftMost -> its right portion l =m +1
        else left portion 

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            m = (l + r) // 2
            if target == nums[m]:
                return m
            # find whether middle belongs to left or right sorted array
            # left sorted portion
            if nums[l] <= nums[m]:
                # now find target portion right
                if target > nums[m] or target < nums[l]:
                    l = m + 1
                else:
                    r = m - 1
            # right sorted portion
            else:
            # left portion
                if target < nums[m] or target > nums[r]:
                    r = m - 1
                else:
                    l = m + 1
        return -1