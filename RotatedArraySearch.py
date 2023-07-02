#TimeComplexity:O(log n)
#SpaceComplexity:O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0 
        high = len(nums)-1
       
        while low <= high:
            mid= low + (high-low)//2

            # If the target is found at the middle index, return the index
            if target == nums[mid]:
                return mid
            # Check if the left half of the array is sorted
            if nums[low] <= nums[mid]:
                # If the target is within the sorted left half, narrow the search to the left half
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                # If the target is not within the sorted left half, narrow the search to the right half
                else:
                    low = mid + 1

            # If the left half is not sorted, the right half must be sorted
            else:
                # If the target is within the sorted right half, narrow the search to the right half
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                # If the target is not within the sorted right half, narrow the search to the left half
                else:
                    high = mid - 1

        # If the target is not found in the array
        return -1