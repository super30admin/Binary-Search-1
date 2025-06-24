# Time Complexity: O(log(m*n))
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        m = len(matrix)
        n = len(matrix[0])

        # set low and high to 0 and last flattened index
        low,high = 0, m*n -1

        while low<=high:
            mid = low + (high-low)//2

            # get the row and col idx by bounding it by n
            # since array is sorted row wise
            row = mid//n
            col = mid%n

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                # search in right side of mid element 
                low = mid + 1
            elif matrix[row][col] > target:
                # search left side of mid element
                high = mid - 1
        return False