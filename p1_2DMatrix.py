class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # check if the matrix exist
        if not matrix or not matrix[0]:
            return False

        #setting rows, column and left,right pointers
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1

        while left <= right:
            # finding middle index and pull the value
            mid = left + (right - left) // 2
            mid_element = matrix[mid // n][mid % n]

            if mid_element == target:
                return True
            
            #compare to update pointer for next search
            elif mid_element < target:
                left = mid + 1
            else:
                right = mid - 1
        
        # return false if search fails
        return False

# ------------------------------------------------------------------------------------------------------------------------
# Time complexity: O(logn)