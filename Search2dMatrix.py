## Time complexity : O(log(n) + log(m)), we search half of the array at every time step
# Space complexity : O(1), space to maintain left and right pointers
# The code ran on github

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
         
        m = len(matrix)
        n = len(matrix[0])

        l = 0; r = m-1
        # Do a binary search to get the corresponding row with the target.
        while l <= r:
            # print(l, r)
            mid = (l+r)//2
            # Return true when target is found
            if matrix[mid][0] == target:
                return True
            # Search left sub array 
            elif matrix[mid][0] < target:
                l = mid + 1
            # Search right sub array 
            else:
                r = mid - 1
        # Get the row where target might be present
        row = r
        l = 0; r = n-1
        # Inside the row, do a binary search to find the target element
        while l <= r:
            mid = (l+r)//2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                r = mid -1
            else:
                l = mid + 1
        # Return false when target is not found
        return False
            