# 2 Pointer Solution: Searching in a 2D matrix
# Complexity: O(m+n)
class Solution:
    def searchMatrix1(self, matrix: List[List[int]], target: int) -> bool:
        # binary search solution, O(log(mn))
        m = len(matrix)
        n = len(matrix[0])
        beg = 0
        end = m*n-1
        
        while(beg<=end):
            mid = (beg + end)//2
            r = mid//n
            c = mid%n
            if(matrix[r][c]==target):
                return True
            
            if matrix[r][c]>target:
                end = mid - 1
            else:
                beg = mid + 1
        
        return False
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(len(matrix)==0 or len(matrix[0])==0):
            return False
        queue = deque([[0,len(matrix[0])-1]])
        while(len(queue)>0):
            i,j = queue.pop()
            if(matrix[i][j]==target):
                return True
            i_down, j_left = i+1, j-1
            if(i_down<len(matrix) and target>=matrix[i_down][j]):
                queue.appendleft([i_down,j])
            elif(j_left>=0 and target<=matrix[i][j_left]):
                queue.appendleft([i,j_left])
            elif(i_down<len(matrix) and j_left>=0):
                queue.appendleft([i_down,j_left])
        return False
