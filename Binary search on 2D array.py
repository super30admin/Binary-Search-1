# // Time Complexity : O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Searching the row to pick if a quite tricky

class Solution(object):
    
    
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        def findinrow(mat,size,target):
            # print(mat)
# Binary search on the given selected row
            low = 0
            high = size - 1
            while(low <= high):
                mid = (low + high) // 2
                if (mat[mid] == target):
                    return True
                elif mat[mid] > target:
                    high = mid - 1
                elif mat[mid] < target:
                    low = mid + 1
            return False

# Binary search on the leading elemnet of the matrix 0th column
        rows = len(matrix)
        cols = len(matrix[0])
        Tlow = 0
        Thigh = rows - 1
        while (Tlow <= Thigh):
            Tmid = (Tlow + Thigh) // 2
            # print(matrix[Tmid][0])
            # check if the target element belongs to a row
            # eg target = 5
            #    matrix = [1,2,5,8,9]
            #    check: 5 > 1 -> true and 5 < 9 -> true so this row is used
            if (matrix[Tmid][0] <= target and matrix[Tmid][cols-1] >= target):
                return findinrow(matrix[Tmid],cols,target)
            elif (target < matrix[Tmid][0]):
                Thigh = Tmid - 1
            elif (target > matrix[Tmid][cols - 1]):
                Tlow = Tmid + 1
        # print('I am here')
        return False

o = Solution()
print(o.searchMatrix([[1,2,3],[4,5,6],[7,8,9]],8))