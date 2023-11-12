# Time Complexity O(log n). Space Complexity O(1)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0 , len(nums) -1
        while left <= right:
            middle = left + (right - left) // 2

            if target == nums[middle]:
                return middle
            
        
            if nums[middle] >= nums[left]:                          # Check if we are in left sorted portion of the array.
                if target > nums[middle] or target < nums[left]:    # If target is greater than middle pointer OR if target is less than left most pointer, shift left pointer.
                    left = middle + 1    
                else:
                    right = middle - 1                              # If target is less than middle OR if target is greater than left most pointer, shift right pointer.            
            else:                                                   # Check if we are in right sorted portion of the array.
                if target < nums[middle] or target > nums[right]:   # If target is less than middle pointer OR if target is greater than right most pointer, shift right pointer.
                    right = middle - 1
                else:
                    left = middle + 1
        return -1