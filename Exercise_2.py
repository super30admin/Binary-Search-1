# Time Complexity: O(log n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if not nums or len(nums) == 0:
            return -1

        low = 0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high-low) //2

            if nums[mid] == target:
                return mid

            # check which side is sorted
            if nums[low] <= nums[mid]:
                # left side sorted
                if nums[low] <= target < nums[mid]:
                    # if target is in the sorted side then search there by decrementing high to mid -1
                    high = mid - 1
                else:
                    low = mid+1
            else:
                # right side sorted
                if nums[mid] < target <= nums[high]:
                    # if target is in the sorted side then search there by incrementing low to mid+1
                    low = mid+1
                else:
                    high = mid -1

        return -1 


        