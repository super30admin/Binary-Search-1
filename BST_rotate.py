# Time Complexity O(log n)
#Space complexity is O(1)



class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[low]:
                if (nums[low] <= target) & (target < nums[mid]):
                    high = mid - 1

                else:
                    low = mid + 1
            else:
                if (nums[mid] < target) & (target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1