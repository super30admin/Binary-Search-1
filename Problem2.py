class Solution:
    # Time complexity - O(log n)
    # Space complexity - O(1)

    # using binary search, find mid element and check which half (left or right) is sorted
    # based on sorted half, check if target lies within that range
    # if yes, narrow search to that half by updating low/high pointers
    # if not, search the other half
    # repeat until target is found or search space is empty
    # if element not present, return -1
    
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target: return mid
            
             # Left sorted
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # Right sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1
