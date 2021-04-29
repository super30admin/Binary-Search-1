# Method 1: Brute Force --> O(mn) where m = number of rows, n = number of columns. Size of matrix = number of elements = m*n
# Method 2: As the elements are sorted, check if the target falls within the first element and last element of each row and if it does, iterate only through that row. --> O(m) + O(n) as you have to iterate through the rows and then iterate through the columns.
# Method 3: As the elements are sorted, check if the target falls within the first element and last element of each row and if it does, iterate only through that row using binary search. --> O(m) + O(logn)
# Method 4: Search the row using binary search and search the column using binary search --> log(m) + log(n)
# Method 5: Treat 2d matrix as 1D array, find corresponding row and column values of middle element in 2D matrix w.r.t index of 1D array; 2D matrix row index of element = 1D array index/no of columns in 2D matrix, 2D matrix column index of element = 1D array index % no of columns in 2D matrix and then do binary search --> log(mn) = log(m) + log(n)

# Method 3

"""
Runtime Complexity: O(mlogn)
Space Compelxity: O(1)

Yes it worked on Leetcode
I had problems with returning boolean values and finding mid values
"""
from typing import List


class Solution:
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + ((high - low) // 2)

            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                return self.binarySearch(arr, mid + 1, high, target)
            elif arr[mid] > target:
                return self.binarySearch(arr, low, mid - 1, target)

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for row in range(0, len(matrix)):
            # print(len(matrix))
            # print(matrix[row][0])
            # print(matrix[row][-1])
            if matrix[row][0] <= target and matrix[row][-1] >= target:
                low = 0
                high = len(matrix[row])-1
                val = self.binarySearch(matrix[row], low, high, target)
                return val
                # break


# obj = Solution()
# arr = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
# obj.searchMatrix(arr, 3)
