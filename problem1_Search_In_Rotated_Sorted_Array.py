# // Time Complexity :O(log(N))
# // Space Complexity : O(log(N)) for the call stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Very tough to identify the various test cases for this problem

#TODO Need to try the first solution as well. Where we locate the point of rotation. 
class Solution:
    
    def binary_search(self, arr, target, low, high):
        # print(arr[low:high + 1])
        if low > high:
            return -1 
        mid = low + (high - low) // 2
        
        if arr[mid] == target:
            return mid
        
        # The key here is to identify the major cases
        # Case1: The location of the rotation: If the lowest elment is larger than the mid element,
        # the rotation is on the right side. Handle accordingly
        elif arr[mid] < arr[low]:
            if (target > arr[mid] and target <= arr[high]):
                return self.binary_search(arr, target, mid + 1, high)
            else:
                return self.binary_search(arr, target, low, mid - 1)
        # Case2: Check if the lowest element is smaller than the mid element, 
        # we know the left side has no rotation. Hence just check the left for target, if not in right
        elif arr[mid] >= arr[low]:
            if target < arr[mid] and target >= arr[low]:
                return self.binary_search(arr, target, low, mid - 1)
            else:
                return self.binary_search(arr, target, mid + 1, high)

    
    def search(self, nums: List[int], target: int) -> int:
        
        
        if len(nums) == 0:
            return -1
        
        
        return self.binary_search(nums, target, 0, len(nums) - 1)
        