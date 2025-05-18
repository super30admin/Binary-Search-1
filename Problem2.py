"""
Time Complexity: O(log(n))

Space Complexity: O(1)

Approach:
We start off by the fundamental idea that in a rotated sorted array, one side of the array is alwaays sorted irrespective of where we divide the array 
We then start off with an arbitrary index and check if left side is sorted, if yes then we check if the target is in the left side, this gives us the ability of apply binary search on left side
If the target is not in the left side, we check if the right side is sorted, if yes then we check if the target is in the right side, this gives us the ability of apply binary search on right side 

"""
class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            # check if the target is the middle element 
            if nums[mid] == target:
                return mid

            # check if the left side is sorted 
            if nums[mid] >= nums[low]:
                # check if the target is present in the left side range ( if so can apply binary search on left side)
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                # eliminate the left side and move to the right side 
                else:
                    low = mid + 1
            else:
                # check if the target is present in the right side range 
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
