# Leetcode: 74 Search a 2D Matrix
# Time Complexity - if m = no. of rows and n = no. of columns in a Matrix
# then the time taken to find the target: O(log(m*n))
# Space Complexity - if we exclude the input matrix we are just using pointers hence, Space - O(1)
# Approach - I used binary search technique using two pointers L, R where L is the start index,
# R is the end index of the matrix we can found this by R = m*n - 1, L = 0 where m = no. of rows & n = no. of columns
# after finding the middle index mid = (L+R)//2, we can calculate the row and col no. using modulo and division
# row = mid // 3, and col = mid % 3, and if matrix[r][c] > target reduce R = mid - 1 else L = mid + 1
# This code ran successfully on Leetcode


def searchMatrix(matrix, target) -> bool:
    m, n = len(matrix), len(matrix[0])
    L = 0
    R = m*n-1
    while L <= R:
        mid = (L+R)//2
        r = mid // n
        c = mid % n
        if r >= m or c >= n:
            return False
        if matrix[r][c] == target:
            return True
        if matrix[r][c] > target:
            R = mid - 1
        else:
            L = mid + 1
    return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 3
print(searchMatrix(matrix, target))
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 13
print(searchMatrix(matrix, target))