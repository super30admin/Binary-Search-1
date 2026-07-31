"""
Approach:
-> Perform binary search on original array
-> If left side is sorted, then check if target exists in that sorted array.
If it exists, eliminate right side, else eliminate left side
-> If right side is sorted, then check if target exists in that sorted array.
If it exists, eliminate left side, else eliminate right side

Time Complexity:
O(log n) - binary search

Space Complexity:
O(1) - constant space

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1

        while(low<=high):
            mid = low + (high-low)//2

            if nums[mid] == target:
                return mid

            # check if left side is sorted (key point: compare mid and low)
            if nums[mid] >= nums[low]:
                # check if target exists in this sorted array
                if nums[low] <= target and target <= nums[mid]:
                    high = mid - 1
                # target does not exist in this sorted array so eliminate this array
                else:
                    low = mid + 1

            # right side is sorted
            else:
                # check if target exists in this sorted array
                if nums[mid] <= target and target <= nums[high]:
                    low = mid + 1
                # target does not exist in this sorted array so eliminate this array
                else:
                    high = mid - 1

        return -1