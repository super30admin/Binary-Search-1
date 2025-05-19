""" 
I implemented the logic using the technique taught in the session. I used binary search to determine which side is sorted, then checked if the target is present on the sorted side. If not, I eliminated the sorted side and moved to the other half, repeating the process.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # left side sorted
                # check if target is on left
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                else:
                    # skip left side
                    low = mid + 1
            else:
                # right side sorted
                # check if the target us on the right
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    # skip right side 
                    high = mid - 1
        return -1