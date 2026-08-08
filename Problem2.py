# Problem2: Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# Time Complexity: O(log n),In every step of the while loop we cut the search window roughly in half.So the number of steps needed grows as log base 2 of n
# Space Complexity: O(1),We only use a few variables like low, high, mid and n.No extra array or data structure is created
# Approach:
# The array was sorted before rotation, so even after rotation,one half of any low to high window is always still normally sorted
# We find mid, check which half is the normal sorted half,then check if target lies inside that sorted half's range
# If yes we search that half, if no we search the other half
# We keep shrinking the window until only one element remains
# then we check that one element directly, since mid is never skipped
# this way we do not miss the answer even without checking mid inside the loop

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        # low and high mark the current search window, it covers full array at start
        low, high = 0, n - 1

        # keep shrinking window while more than one element remains
        while low < high:
            # mid is the middle index of current window
            mid = low + (high - low) // 2

            # check if left half from low to mid is the normally sorted half
            if nums[low] <= nums[mid]:
                # left half is sorted, check if target value falls inside this range
                if nums[low] <= target <= nums[mid]:
                    # target must be in left half, shrink high down to mid
                    # we use mid and not mid minus 1 because mid itself could be the answer
                    high = mid
                else:
                    # target is not in left half, so it must be in right half
                    # safe to move past mid here since we already ruled mid out
                    low = mid + 1

            else:
                # left half is not sorted, so right half from mid to high must be sorted
                if nums[mid] <= target <= nums[high]:
                    # target must be in right half, shrink low up to mid
                    # we use mid and not mid plus 1 because mid itself could be the answer
                    low = mid
                else:
                    # target is not in right half, so it must be in left half
                    # safe to move past mid here since we already ruled mid out
                    high = mid - 1

        # loop ends when low equals high, meaning only one index remains
        # check that single remaining index directly against target
        if nums[low] == target:
            return low

        # target was never found in the array
        return -1

