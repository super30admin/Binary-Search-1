# Time Complexity is O(log(mn)), where m x n is array size
# Space Complexity is O(1)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        """
        Considering the array as one big sorted array
        """
        def val(i):
            row = i//len(matrix[0])
            col = i%len(matrix[0])
            #print(row,col)
            return matrix[row][col]
        
        low = 0
        high = len(matrix)*len(matrix[0])-1
        while(low <= high):
            mid = (low + high)//2
            if(val(mid) == target):
                return True
            elif(target < val(mid)):
                high = mid-1
            else:
                low = mid+1
        return False