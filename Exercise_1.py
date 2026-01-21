'''
    74 Search a sorted 2D matrix
    https://leetcode.com/problems/search-a-2d-matrix

    You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row. Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.

    Example 1:
        Input: matrix = [[1, 3, 5, 7],
                        [10,11,16,20],
                        [23,30,34,60]],
                target = 3
        Output: true

    Solution:
        1. Method 1: Search tgt among the first elements of each row to find the desired row. Then, from the desired row, search tgt among the columns in that row.
        Time: O(log M + log N) = O(log MN), Space: O(1)

        2. Method 2: We can imagine that the elements are arranged in a 1D array of size MN, i.e. 0 <= k <= MN-1. To map the 1D index to a pair of indices (i,j) in 2D array, we can do:
        i = k // M, j = k % M
        For eg, for a 2D array of 3x4 elements (M=3, N=4), the corresponding 1D array is of size 12. Then the element at k=9 (10th element) of 1D array can be mapped to row = 9 // 4 = 2, col = 9 % 4 = 1.
        Thus, 9 -> (2,1)
        Time: O(log MN), Space: O(1)
        https://youtu.be/8hyOCScF1q0?t=372
'''
class Solution:
    def searchMatrix(self, matrix, target):
        # Method 2
        M = len(matrix) # rows
        N = len(matrix[0]) # columns
        s = 0
        e = M*N - 1
        found = False
        while s <= e: # O(log MN)
            mid = s + (e-s)//2 # same as int((s+e)/2) but prevents overflow
            row = mid // N
            col = mid % N
            if matrix[row][col] == target:
                found = True
                break
            elif matrix[row][col] > target:
                e = mid -1
            else:
                s = mid + 1
        return found

def run_search_matrix():
    A = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    print(f"Matrix = {A}")
    soln=Solution()
    for tgt in [3, 11, 6, 30]:
        found = soln.searchMatrix(A, tgt)
        print(f"tgt = {tgt}, Found = {found}")

run_search_matrix()
