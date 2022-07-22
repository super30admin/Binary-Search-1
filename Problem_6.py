# Time Complexity : O(log n) since we are using binary search only. Even rotqation function takes O(log n) time only since its also basically a binary search
# Space Complexity : O(n) for the array. No additional auxiliary space is required
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
    def Rotation(self,nums,low,high):
        if nums[low] < nums[high]:
            return 0 # Return 0 if the array is in normal order i.e not rotated at all
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] > nums[mid+1]:
                return mid+1 # If the next element after mid is less than mid then the mid+1 index is where rotation starts
            # Since each elements should be in ascending order, if mid+1 element is less than mid element then that is where rotation starts
            elif nums[mid] < nums[low]:
                high = mid-1 # Check mid with start of the range at low. In case low element is greater we change high to mid-1
            else:
                low = mid+1 # If mid element is less than low element then rotation starts in its right half.
    
    def BinarySearch(self,nums,low,high,target):
        # Implementing normal binary search
        while low <= high:
            mid = low + (high-low) // 2 # Calculate mid element
            if nums[mid] == target:
                return mid  # Return mid if target is the mid element
            elif target < nums[mid]:
                high = mid-1 # If target is less than mid element its in left half of mid
            else:
                low = mid+1 # If target is more than mid element its in right half of mid
        return -1 # Returns -1 if element is not found above
    
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1: # Edge case of length 1. We can check it directly and determine
            if target == nums[0]:
                return 0
            else:
                return -1
        rotate = self.Rotation(nums,0,len(nums)-1) # Call and find out the index at which rotatiopn starts
        
        if rotate == 0:
            return self.BinarySearch(nums,0,len(nums)-1,target) # If there is no rotation perform normal binary search
        
        if nums[rotate] == target:
            return rotate # If element at start of rotate is the target then return this index
        elif target < nums[0]: # If target is less than first element of array, then perform binary search on the right half of the start of rotate
            return self.BinarySearch(nums,rotate+1,len(nums)-1,target)
        else:
            return self.BinarySearch(nums,0,rotate-1,target) # If target is more than first element, perform binary search on the left half of the rotate index
        