from pip import List
#Time Complexity = O(logn)
#Space Complexity = 1

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(matrix==None or len(matrix)==0):
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n -1
        while(low<=high):
            mid = int(low + ((high-low)/2)) # Used to avoid integer overflow
            row = int(mid/n)
            col = mid % n
            if(target == matrix[row][col]):
                return True
            elif(target<=matrix[row][col]):
                high = mid-1
            else:
                low = mid+1
        return False

#s = Solution()
#print(s.searchMatrix([[1,2,3],[4,5,6]],5))
