# Binary-Search-1


## Problem1 
Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix)==0:
            return False
        rows = len(matrix)
        cols = len(matrix[0])
        low = 0
        high = (rows*cols) - 1
        while low<=high:
            mid = (high-low)//2 +low
            i,j = divmod(mid, cols)
            if target == matrix[i][j]:
                return True
            elif target > matrix[i][j]:
                low = mid+1
            else:
                high = mid - 1
        return False
        
        # Time Complexity: O(Logn)
        #  Space Complexity: since a 2d array is involved - O(N^2)

## Problem1 
Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if target == nums[mid]:
                return mid
            # sorted left
            elif nums[low] <= nums[mid]:
                if(nums[low] <= target and nums[mid] >= target):
                    high = mid - 1
                else:
                    low = mid + 1
            # sorted right
            elif nums[mid] <= nums[high]:
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1

    #Time Complexity: O(logN)
    #Space Complexity: O(N)
    



## Problem2
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi * 2;
        }
        int low = hi / 2;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if ( val > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

#Time Complexity: O(logn)
#Space Complexity: O(N)

