# Time Complexity : O(log m * n) m is the number of rows and n is number of columns
# Space Complexity : O(1) no additional space is required
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
    # Main logic for this problem was to come up with finding a way to determine row and column of the mid element computed.


# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        #base case
        if not matrix or len(matrix) == 0:
            return False
        
        m = len(matrix) #rows
        n = len(matrix[0]) #columns

        low = 0
        high = m * n - 1 #totalelements, index starts from 0 so -1

        while low <= high:

            #to prevent integer overflow and always stay within the range
            mid = low + (high - low) // 2 

            row = mid // n #get the row index
            col = mid % n #get the column index

            if matrix[row][col] == target:
                return True

            elif target < matrix[row][col]:
                high = mid - 1

            else:
                low = mid + 1

        return False