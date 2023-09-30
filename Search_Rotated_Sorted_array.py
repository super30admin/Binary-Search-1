# Time Complexity - O(log n)
# Space Complexity - O(1)

# Approach - Ideally in a rotated sorted array, one half of the array is sorted. 
# So to use Binary Search, the search space should be cut in half. So, here the condition would be 
# to check if the left half of the array is sorted or the right half and based on that cut down the
# search space by checking if the target lies b/w low & mid or b/w mid & high 

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1
        while (low <= high):
            mid = (low + high)//2
            print(nums, low, mid, high)
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                # left half is sorted array
                if nums[low] <= target and target <= nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right half is sorted array 
                if nums[mid] <= target and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1