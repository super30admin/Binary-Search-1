# Time Complexity = O(logn)
# Space Complexity = O(1)


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + ((high - low) // 2)
            
            if target == nums[mid]:
                return mid

            # To determine which side of the array could be sorted

            elif nums[low] > nums[mid]:   #Right array is sorted
                # Target lies in the right sub array
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                # Target lies in the left sub array
                else:
                    high = mid - 1
            
            elif nums[low] <= nums[mid] :  #Left array is sorted
                # Target lies in the left sub array
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                # Target lies in the right sub array
                else:
                    low = mid + 1
                    
        return -1
                              