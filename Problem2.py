"""
TC: O(log(N)) {we just iterate once in the whole array (stashing the unwanted half everytime) with the fact that atleast one part of the array is gonna be sorted}
SC: O(1) {no extra space is being used}
"""

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1

        while low < high:
            mid = low + (high-low)//2

            if nums[mid] == target:
                return mid
            
            if nums[mid] >= nums[low]:
                # it is left sorted
                if nums[low] <= target and nums[mid] > target:
                    # target lies in this
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # its right sorted
                if nums[high] >= target and nums[mid] < target:
                    # target lies in this
                    low = mid + 1
                else:
                    high = mid -1
        if nums[low] == target:
            return low
        return -1


        
