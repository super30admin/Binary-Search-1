# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        
        def findMinIndex(left, right):
            '''Function to find Minimum Index'''
            if len(nums) == 1 or nums[0] < nums[-1]:
                return 0
            
            while left <= right:
                pivot = left + (right - left) # 2
                if nums[pivot] < nums[pivot - 1]:
                    return pivot
                
                if nums[pivot] < nums[0]:
                    right = pivot - 1
                
                else:
                    left = pivot + 1
            
            return -1
        
        
        def binarySearch(left, right):
            '''Plain Old Binary Search'''
            while left <= right:
                pivot = left + (right - left)
                if nums[pivot] == target:
                    return pivot
                elif target < nums[pivot]:
                    right = pivot - 1
                else:
                    left = pivot + 1
            
            return -1
        
        
        left = 0
        right = len(nums) - 1
        # We need the minimum index because using the minimum index and the first element we can divide the
        # search space.
        minIndex = findMinIndex(left, right)
        if minIndex == 0:
            return binarySearch(left, right)  
        if target == nums[minIndex]:
            return minIndex
        if target >= nums[0]:
            return binarySearch(left, minIndex - 1)
        else:
            return binarySearch(minIndex + 1, right)
            