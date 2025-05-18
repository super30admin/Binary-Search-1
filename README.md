# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// Time Complexity : O(log n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Convert 2D-1D - m rows, n columns - index = index % column + index % rows
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m*n - 1
        # how to get (m,n) from mid? (m,n) = (mid//n, mid%n) 
        while left <= right:
            mid = (right + left)//2

            row = mid//n
            col = mid % n 
            
            if target == matrix[row][col]:
                return True

            elif target < matrix[row][col]:
                right = mid - 1
            elif target > matrix[row][col]:
                left = mid + 1
        return False



## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # 1. Find start, mid, end
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (right-left)//2 + left
        # 2. Find asc -> if start < mid or if mid < end
            if target == nums[mid]:
                return mid

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1  # Search left
                else:
                    left = mid + 1   # Search right

            else: 
                if nums[mid] < target <= nums[right]:
                    left = mid + 1   # Search right
                else:
                    right = mid - 1  # Search left
        return -1

        # 3. check if asc_start < target < asc_end
        # 4. if yes -> binary sort
        # 5. if no -> go to 1



## Problem3
Search in Infinite sorted array: 
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
// Time Complexity : O(log n)
// Space Complexity : -
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : didn't have access to leetcode premium

def search_unknown_length(arr, target):
    left, right = 0, 1

    while arr[right] < target:
        left = right
        right *= 2
    
    while left <= right:
        mid = (left+right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        elif arr[mid] > target:
            high = mid - 1
    return -1