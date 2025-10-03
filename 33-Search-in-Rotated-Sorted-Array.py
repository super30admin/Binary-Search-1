class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high)//2 # O(1)
            if nums[mid] == target:
                return mid

            # check first half
            elif nums[low] <= nums[mid]: # O(1)
                if (nums[low] <= target) and (target < nums[mid]):  # Line 12 and 19 shrink search in half so O(log n)
                    high = mid - 1
                else:
                    low = mid + 1

            # Check second half
            else:
                if (nums[mid] < target) and (target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1

        return -1