# Time Complexity : O(m+logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # First we will search the last element of every row and see if it is less than or equal to the target
        # If it is equal to the target, we will return the index.
        # If not, we will continue our search. 
        for i in range(len(matrix)):
            if matrix[i][-1] < target:
                continue
            elif matrix[i][-1] == target:
                return True
            # if the last element of the row is greater than the target, then we will apply binary search 
            # on that row to find the target.
            else:
                l = 0
                r = len(matrix[i])-1
                while l<=r:
                    mid = l + (r-l)//2
                    if matrix[i][mid] == target:
                        return True
                    elif matrix[i][mid] > target:
                        r = mid-1
                    else:
                        l = mid+1
        return False
