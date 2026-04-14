class Solution:
    def search(self, nums, target):
        n = len(nums)
        low, high = 0, n - 1
        while low <= high:
            mid = low + (high - low) // 2
            curr = nums[mid]
            if curr == target:
                return mid
            if nums[low] <= curr:
                if nums[low] <= target < curr:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if curr < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

nums = [4,5,6,7,0,1,2]
target = 3
sol = Solution()
print(sol.search(nums,target))