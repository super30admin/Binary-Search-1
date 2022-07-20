# Search in 2D Matrix
'''
Leetcode all test cases passed: Yes
Solution:
    Length of rows (r) and Length of columns (c)
    Space Complexity: O(1)
    binary_search(self, arr, target):
        Let n be the length of the array
        Time Complexity: O(log n)
    searchMatrix(self, matrix, target):
        Time Complexity: time to fetch first column + 
                         time to search first column + 
                         time to bisect first column + 
                         time to search bisected row = O(c) + O(log c) + O(log c) + O(log r) = O(c)
    
'''


import bisect


class Solution:
    def binary_search(self, arr, target):
        l = 0
        r = len(arr) - 1
        while l <= r:
            mid = (l + r) // 2
            if arr[mid] == target:
                return True
            elif arr[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False

    def searchMatrix(self, matrix, target):
        first_column = [row[0] for row in matrix]
        if self.binary_search(first_column, target) == True:
            return True
        index = bisect.bisect_left(first_column, target)
        if index != 0:
            index -= 1
        return self.binary_search(matrix[index], target)
