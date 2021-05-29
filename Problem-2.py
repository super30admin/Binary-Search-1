"""
Approach:
When we partition the array, one of the 2 partitions will always be sorted. We can modified our generic binary search
approach based on this pattern. The idea is to pick the right partition within which our target might be present.
1) Find the sorted partition
2) out target could be in either sorted or unsorted partition, check the sorted partition first
3) update your pointers (search space) based on where the target might be present
"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1

        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1

            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

"""
Time Complexity: O(log n) since we are reducing our search space everytime by 2

Space Complexity: O(1)
"""