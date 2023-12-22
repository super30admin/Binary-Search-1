#Time Complexity: O(log n)
#Space Complexity: O(1)

class Solution:
    def search(self, nums: list[int], target: int) -> int:
        #base case to check weather the array is empty or not
        if not nums or len(nums) == 0:
            return -1

        n = len(nums)  # Use len() instead of length
        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:  #to check which part is sorted
                # Left part is sorted
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
            
                if target > nums[mid] and target <= nums[high]: #right part is sorted. # check the target is lying in the right half
                    low = mid + 1
                else:
                    high = mid - 1

        return -1







        