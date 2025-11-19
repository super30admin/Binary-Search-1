'''
In this problem we need to find the target inside a 2-D matrix
I performed binray search operation to find the target
Here I am considering this 2-D matrix as one long array:
First I comapred the mid elemnt with target, mid is calculated and then converted to 2-D by finding the row and column positions
If the target is not equal to mid, we move the low and high pointers comparing target to mid.
'''
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # no of rows
        m = len(matrix)
        # no of columns(len of first row)
        n = len(matrix[0])

        low = 0
        high = m * n - 1

        while low <= high:
            mid = (low + high) // 2
            # to find which row the mid is in
            row = mid // n
            # to find which column the mid is in
            col = mid % n
            # comparing the target with mid
            if matrix[row][col] == target:
                return True
            # if mid is less than target
            elif matrix[row][col] < target:
                # move towards right
                low = mid + 1
            else:
                # move towards left
                high = mid - 1
        return False

'''
Time Complexity: O(log(m*n))
Since we are performing binary search operation on m*n length array or 2-D array.

Space Complexity: O(1)
we did not use any extra space.
'''