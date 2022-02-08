# Time: O(n+log(m))
# Space: O(1)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        for row in matrix:
            #print(row)
            if row[0] <= target and row[len(row)-1] >=target:
                #print(row)
                left = 0
                right = len(row) - 1
                while left <= right:
                    middle = left+((right-left)/2)
                    if row[middle] == target:
                        return True
                    elif row[middle] < target:
                        left = middle + 1
                    else:
                        right = middle - 1
                break
                        
        return False
        
