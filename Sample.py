
# Your code here along with comments explaining your approach in three sentences only

# Binary-Search-1

## Problem1 
# Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
# Approach
# Code first selects the row in which the target element may be present by using the binary search on the first column elements
# In the next phase, the target element is searched in the row which was selected in the first phase

# Time Complexity : O(nlogn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        if (m == 1):
            if target in matrix[0]:
                return True
            else:
                return False
        elif (m == 2):
            for i in range(m):
                if target in matrix[i]:
                    return True
            return False

        strt = 0
        end = m - 1
        mid = (strt + end) >> 1
        fnd = False

        while (strt <= end):
            mid = (strt + end) >> 1
            # print(strt, end, mid)
            if (target == matrix[mid][0]):
                return True
            elif ((mid + 1) < m and matrix[mid][0] <= target <= matrix[mid+1][0]):
                fnd = True
                # print('1')
                break
            elif (mid == m - 1 and matrix[mid][0] <= target):
                fnd = True
                # print('2')
                break
            elif (matrix[mid][0] > target):
                end = mid - 1
            else:
                strt = mid + 1

        if (fnd == True):
            if target in matrix[mid] or (mid+1 < m and target in matrix[mid+1]):
                return True
        
        return False


## Problem2 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
#Approach
# we need to do a binary search. 
# we need to check whether left sorted or right sorted by comparing the low and middle element.
# Based the comparsion will updated the low and high pointers and continue till the element is found.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while(low <= high):
            mid = low + (high - low)//2

            if nums[mid] == target: return mid

            else:
                if nums[low] <= nums[mid]:
                    if nums[low] <= target and nums[mid] > target:
                        high = mid -1
                    else:
                        low = mid + 1
                else:
                    if nums[mid] <= nums[high]:
                        if nums[mid] <= target and nums[high] >= target:
                            low = mid + 1
                        else:
                            high = mid - 1
                    else:
                        if nums[low] == target: return low
        return -1
        


## Problem3
# Search in Infinite sorted array: 
# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
# Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

# Approach
# In the first phase we try to get the range of elements in such a way that the target element is present in this range.
# Once we have a range of elements, we can use the binary search method to search for target in this range of elements.

# Time Complexity : O(nlogn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:

        lw = 0 
        hg = 1

        while reader.get(hg) < target:
            lw = hg
            hg *= 2

        while lw <= hg:
            md = lw + (hg - lw) // 2
            num = reader.get(md)
            if num == target:
                return md
            elif num > target:
                hg = md - 1
            else:
                lw = md + 1

        return -1


