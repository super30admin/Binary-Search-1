# Using binary search technique
# find the mid using low and high pointer.
# at every point, we need to check whether the left or right is sorted.
# set the new low and high pointers. Calculate the new mid pointer based on them.
# return mid, when the value at mid is equal to target.
# return -1 at the end.
# Time complexity - O(log n)
# Space complexity - O(1)
# Did this code run on leetcode? - yes

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1
        
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]: # if left side is a sorted array
                if nums[low] <= target <= nums[mid]: # if the element lies in the left
                    high = mid - 1
                else: # if the element lies in the right
                    low = mid + 1
            else:
                if nums[mid] <= target <= nums[high]: # if the element lies in the right
                    low = mid + 1
                else: # if the element lies in the left
                    high = mid - 1
            
        return -1 

        