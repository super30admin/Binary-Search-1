class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums)-1
        
        while (low <= high):
            mid = low + (high-low) // 2

            # Happy Case
            if nums[mid] == target:
                return mid
            
            # Left half is sorted
            elif (nums[low] <= nums[mid]):
                # Target Lies in sorted half
                if (target >= nums[low] and target < nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            
            # Right half is sorted
            else:
                # Target Lies in sorted half
                if (target > nums[mid] and target <= nums[high]):
                    low = mid+1
                else:
                    high = mid-1

        return -1
    
### Complexity Analysus ###

# Time: O(logN) --> Reducing search space in Half during every iterating
# Space: O(1) --> Constant space used for low, high and mid.