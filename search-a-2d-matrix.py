#Time Complexity : O(log m*n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        row = len(matrix)

        if row == 0:
            return False

        col = len(matrix[0])

        left= 0
        right = row*col - 1

        while left <= right:
            mid = (left + right) // 2
            pivot_element = matrix[mid//col][mid%col]
            if pivot_element == target:
                return True
            elif pivot_element > target:
                right = mid - 1
            else:
                left = mid + 1

                

# Intially consider it as a normal array. Apply normal binary search, get the mid index. 
# Then convert it into index of matrix by matrix[mid//n][mid%n] and then compare it with the target and follow binary search tree.