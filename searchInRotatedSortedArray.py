class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0 
        r = len(nums) -1
        while l <= r:
            mid = l + (r-l)//2
            if nums[mid] == target:
                return mid
            if nums[l] <= nums[mid]:
                if nums[mid] >= target and target >= nums[l]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if target <= nums[r] and target >= nums[mid]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1
        