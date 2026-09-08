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
    @staticmethod
    def lin2mat(index, N):
        i = index // N
        j = index % N
        return (i, j)

    def searchMatrix(self, matrix, target):
        m = len(matrix) # num rows
        n = len(matrix[0]) # num cols
        s, e = 0, m*n - 1
        while s <= e: # O(log mn)
            mid  = s + (e - s) // 2
            i, j = Solution.lin2mat(mid, n)
            if matrix[i][j] == target:
                return True

            if target < matrix[i][j]:
                e = mid - 1
            else:
                s = mid + 1

        return False

def run_search_matrix():
    A = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    print(f"Matrix = {A}")
    soln=Solution()
    for tgt in [3, 11, 6, 30]:
        found = soln.searchMatrix(A, tgt)
        print(f"tgt = {tgt}, Found = {found}")

run_search_matrix()
