# // Time Complexity : O(log(n)) + O(log(m))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only

class Solution:
    def searchMatrix(self, matrix, target):
        n = len(matrix)
        m = len(matrix[0])
        low = 0 
        ## finding the total length of array by doing m*n -1
        high = (m*n) -1

        ## we treat this matrix as a single sorted array and perform the search
        while (low<= high):

            mid = low+(high-low)//2

            ##We find the row and column using the given manipulation
            row = mid // m
            col = mid % m

            if matrix[row][col] == target:
                return True
            
            if target < matrix[row][col]:
                high = mid-1
            else:
                low =mid+1
            
        return False



        