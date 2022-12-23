# Exercise_1: Search A 2D Matrix
# Time Complexity: O(log(M*N)), where M is the number of rows and N is the number of columns
# Space Complexity: O(1)
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/search-a-2d-matrix/)
# Challenges: None

# Coding Approach:
# If the matrix is empty, return False
# Input matrix can be treated as a sorted array. 
# If there is a matrix, find the number of rows and columns
# Set low to 0 (start of the sorted array) and high to m*n - 1 (end of the sorted array)
# While low is less than or equal to high, compute the mid index
# Compute the row and column index of the mid index
# If the value at the mid index is equal to the target, return True
# If the value at the mid index is greater than the target, set high to mid - 1 (search left since all values to the right are greater)
# If the value at the mid index is less than the target, set low to mid + 1 (search right since all values to the left are lesser)


def searchMatrix(matrix, target):
    if matrix == None or len(matrix) == 0:
        return False
    m = len(matrix)
    n = len(matrix[0])
    low = 0
    high = m*n - 1
    while low <= high:
        mid = low + (high - low)//2
        r = mid//n
        c = mid%n
        if matrix[r][c] == target:
            return True
        elif matrix[r][c] > target:
            high = mid - 1
        else:
            low = mid + 1
    return False

print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13))