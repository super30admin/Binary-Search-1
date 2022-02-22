# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # Initialize start and end
        start = 0
        end = len(nums) - 1
        # Binary Search
        while start <= end:
            mid = (start + end) // 2
            # Return mid since we found target
            if nums[mid] == target:
                return mid
            # Case where pivot elem is larger than start elem
            elif nums[mid] >= nums[start]:
                # If target is between start and mid
                if target >= nums[start] and target <= nums[mid]:
                    # Move end closer to mid
                    end = mid - 1
                else:
                    # Move start closer to mid
                    start = mid + 1
            else:
                # Target is between mid and end
                if target <= nums[end] and target >= nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1
