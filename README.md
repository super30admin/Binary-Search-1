# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time complexity - O(logmn)
Space complexity - O(1)

class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix)==0 or matrix==None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m*n-1
        while low<=high:
            mid = low+(high-low)//2
            r = mid//n
            c = mid%n
            if matrix[r][c]==target:
                return True
            elif matrix[r][c]>target:
                high = mid-1
            else:
                low = mid+1
        return False

## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

Time complexity - O(logn)
space complexity - O(1)

class Solution:
    
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low+(high-low)//2
            if nums[mid]==target:
                return mid
            elif nums[low]<=nums[mid]:
                if nums[low]<=target and target<nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if nums[mid]<target and nums[high]>=target:
                    low = mid+1
                else:
                    high = mid-1
        return -1



## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

Time complexity: O(logn)
space complexity: O(1)

class solution:

    def search(self,reader,target):
        low = 0
        high = 1
        while high < target:
            low = high
            high = 2*high
        while low<=high:
            mid = low+(high-low)//2
            if reader[mid]==target:
                return mid
            elif reader[mid]>target:
                high = mid-1
            else:
                low = mid+1
    return -1

