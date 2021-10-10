# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l=0
        if len(matrix)==0:
            return False
        h=len(matrix)*len(matrix[0])-1
        while l<=h:
            m=(l+h)//2
            p=matrix[m//len(matrix[0])][m%len(matrix[0])]
            if p==target:
                return True
            elif p>target:
                h=m-1
            else:
                l=m+1
        return False
                
        
## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>=nums[l]:
                if target>=nums[l] and target<nums[mid]:
                    h=mid-1
                else:
                    l=mid+1
            else:
                if target<=nums[h] and target>nums[mid]:
                    l=mid+1
                else:
                    h=mid-1
        return -1
            

## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        l, r = 0, 1
        while reader.get(r) < target:
            l = r
            r <<= 1
        while l <= r:
            pivot = l + ((r - l) >> 1)
            num = reader.get(pivot)
            
            if num == target:
                return pivot
            if num > target:
                r = pivot - 1
            else:
                l = pivot + 1
        return -1
        

