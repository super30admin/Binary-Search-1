# Time Complexity: O(log(n))
# Space Complexity: O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # There will be one place in the array where the left element will be greater than the immediate next element.
        # Considering any index, we can say that at any index one part of the array would be sorted.
        # This means we can easily check if target lies in the sorted array or not. 
        # If it lies in the sorted array, that means we can appky binary search on that.
        # If not then we know which part to search for in the divided array.
        left = 0
        right = len(nums) - 1
        while left <= right:
            # Check considering mid, which part is sorted and if target lies in the sorted array
            mid = left + ((right - left)//2)
            if nums[mid] == target:
                return mid
            elif (nums[left] <= nums[mid]):
                # Left array is sorted
                if (nums[left] <= target and target < nums[mid]):
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # This means right part is sorted. So we check for the element in right part
                if (nums[mid] < target and target <= nums[right]):
                    left = mid + 1
                else:
                    right = mid - 1
        return -1