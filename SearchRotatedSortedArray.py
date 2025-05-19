# Time Complexity: log(n)
# Space Complexity: O(1)

# One side of the array (left or right of mid) is always sorted, even after rotation.
# Calculate mid if our target is at mid then return the mid
# If target is not the mid then use the sorted part of the array to move left and right pointers.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1

        while low <= high:
            mid = low + (high-low)//2

            if target == nums[mid]:
                return mid

            if nums[low] <= nums[mid]:
                if nums[low] <= target <= nums[mid]:
                    high = mid-1
                else:
                    low = mid+1

            else:
                if nums[mid] <= target <= nums[high]:
                    low = mid+1
                else:
                    high = mid-1

        return -1