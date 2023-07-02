# // Time Complexity : O(log m + log n), where m is number of rows and n is the number of columns.
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach in three sentences only
#   Since, we know last element of each row is smaller than the 1st element of the next row, we can visualize the 2D array as a sorted 1 D array ranging from 0 to (m*n)-1 indices.
#   We get the 2D index from 1D indexes by,
#   row=1D index/(n)
#   col=1D index%n
#   Then, just run Binary search on this 1D array to find target element.                                
# Now, at this point we have a reduced range of elements, and now apply binary search to find the target element.

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix: return -1
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=(m*n)-1

        while low<=high:
            mid=low+(high-low)//2
            r=mid//n
            c=mid%n

            if matrix[r][c]==target: 
                return True

            elif matrix[r][c]>target: 
                high=mid-1
            else:
                low=mid+1
        
        return False
