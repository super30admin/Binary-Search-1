"""
Time complexity: O(log(mn))
Space complexity: O(1)
Approach: Treat the entire matrix as one long m*n array. Perform binary search on it.

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            print(mid, " ", low, " ", high)
            if nums[mid] == target:
                return mid
            elif nums[mid] < nums[low]:
                if nums[mid] > target or nums[low] <= target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] > target and nums[low] <= target:
                    high = mid - 1
                else:
                    low = mid + 1
        return -1