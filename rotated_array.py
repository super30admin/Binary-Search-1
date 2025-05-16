# Started with setting low, high pointers and Divided the array to half and checked for target. If found returned the mid (index)
# Rotation concept : Checked if any half of the array is sorted and if it is sorted then searched for target is within the sorted half. 
# If not found then searched within other half 

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) - 1

        while(low<=high):
            mid = (low + high) // 2

            if nums[mid] == target:
                return mid
                
            if nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1

        return -1