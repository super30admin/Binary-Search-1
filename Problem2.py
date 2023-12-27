# Time Complexity: O(log(n))
# Space Complexity: O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l)// 2
            if nums[mid] == target:
                return mid
            # mid is in left sorted half
            if nums[l] <= nums[mid]:
                if nums[mid] > target and nums[l] <= target:
                    r = mid - 1
                else:
                    l = mid + 1
            # mid is in right sorted half
            else:
                if nums[mid] < target and nums[r] >= target:
                    l = mid + 1
                else:
                    r = mid - 1
                
        return -
