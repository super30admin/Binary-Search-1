#Time Complexity = O(logn)
#Successfully compiled and run on Leetcode

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        rows = len(matrix)
        cols = len(matrix[0])

        if rows == 0: #if matrix not exists
            return False

        left = 0
        right = (rows * cols) - 1 # setting left and right pointers in array of 2d matrix

        while (left <= right):
            mid_idx = (left + right) // 2 # getting pivot index
            mid_ele = matrix[mid_idx // cols][mid_idx % cols] #logic to get the pivot element in 2d array

            if target == mid_ele: #basic binary search logic
                return True
            else:
                if target < mid_ele:
                    right = mid_idx - 1
                else:
                    left = mid_idx + 1
        return False
