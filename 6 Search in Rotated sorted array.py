class Solution(object):
    def search(self, nums, target):
        left = 0
        right = len(nums) - 1 

        # Using binary search to find the target in a rotated sorted array
        while left <= right:
            mid = left + (right - left) // 2
            
            # Checking if the middle element is the target
            if nums[mid] == target:
                return mid

            # Checking if the left half is sorted
            if nums[left] <= nums[mid]:
                # Checking if the target is in the left sorted half
                if nums[left] <= target <= nums[mid]:
                    # Moving the right pointer to search in the left half
                    right = mid - 1
                else:
                    # Moving the left pointer to search in the right half
                    left = mid + 1 
            else:
                # Checking if the target is in the right sorted half
                if nums[mid] < target <= nums[right]:
                    # Moving the left pointer to search in the right half
                    left = mid + 1
                else:
                    # Moving the right pointer to search in the left half
                    right = mid - 1
        # Returning -1 if the target is not found
        return -1
    
#Time Complexity: O(log n) because we are using binary search
# Space Complexity: O(1) because we are using constant space 

        