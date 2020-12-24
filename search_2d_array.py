# Approach:
# Brute Force: We can iterate over both the rows and columns of the given matrix (which is a list of list in python) and check if matrix[row][col] is the match
# This approach would require 2 for loops(nested) and the time complexity would be O(M*N) where M and N are rows, cols respectively
# Optimization: Taking adv of binary search in a sorted matrix, we can start from top most element of last column and apply binary search
# If current_element > target -- we can neglect the entire column as it is in the sorted ascending order
# If current_element < target -- we can shift to next row since it is in ascending order as well
# Time complexity - O( M + N) ( as worst case the element maybe poistioned in the bottom most position in matrix and we are starting from top corner)
# Space Complexity - O(1)
# Edge Case : If empty matrix return there
# I think we can optimize to reduce time complexity further but not sure how
# Successfully ran on leetcode

def searchSortedArray(matrix, target):

    # Edge case
    if len(matrix) == 0:
        return

    row = 0
    col = len(matrix[0]) - 1

    # to ensure we are in the limits of the matrix
    while row <= len(matrix) -1 and col >= 0:

        if matrix[row][col] > target:
            col -= 1

        elif matrix[row][col] < target:
            row += 1

        else:
            return True

    return False