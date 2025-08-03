class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid

            # Left half is sorted
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1

            # Right half is sorted
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
                 
        return -1

nums = [4,5,6,7,0,1,2]
target = 0

sol = Solution()
print(sol.search(nums, target))  

# Time Complexity:
#   O(log n), where n is the number of elements in the array
#   Because at each step, we eliminate half of the array — standard binary search behavior,
#   even with the rotation check.

# Space Complexity:
#   O(1) — we use only a few pointers (left, right, mid)

# Did this code successfully run on Leetcode: Yes, 33 (Search in Rotated Sorted Array)

# Any problem you faced while coding this:
#   Yes — using regular binary search logic fails due to the rotation.
#   I learned that at every step, at least one half of the array (left or right) is sorted.
#   So we compare the target with the sorted half and adjust our search boundaries accordingly.
#   Also fixed an off-by-one error by correctly setting `right = len(nums) - 1` instead of `len(nums)`.

