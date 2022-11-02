# Time Complexity : O(logN) or O(log(rows*cols))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        if len(matrix) == 0:
            return False

        rows = len(matrix)
        cols = len(matrix[0])
        start:int = 0
        end:int = rows*cols - 1

        while start <= end:
            mid:int = start + ((end - start)//2)
            # for the first index we need to find the row number and since each row has
            # cols number of elements in it we can get the row number by division
            # for the 2nd index we need to bind the value in a range of number of cols
            # so we use the modulo function
            curr:int = matrix[mid//cols][mid%cols]

            if curr > target:
                end = mid - 1
            elif(curr < target):
                start = mid + 1
            else:
                return True
        return False