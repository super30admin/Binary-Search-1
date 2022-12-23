class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums or len(nums)==0:
            return -1
        l = 0
        r = len(nums) - 1
        if nums[l] == target:
            return l
        if nums[r] == target:
            return r

        while l + 1 < r:
            m = (l + r) // 2
            if nums[m] == target:
                return m

            if nums[m] < nums[r]:
                if nums[m] <= target <= nums[r]:
                    l = m
                else:
                    r = m
            else:
                if nums[l] <= target <= nums[m]:
                    r = m
                else:
                    l = m

        return -1