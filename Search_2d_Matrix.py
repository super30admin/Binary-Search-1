# Time Complexity : O(logn)
# Space Complexity : O(1)

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        row = len(matrix)
        
        col = len(matrix[0])
        
        for i in range(row):
            
            if matrix[i][col -1] >= target:
                
                if target >= matrix[i][0] :
                    
                    #apply binary search for that row only
                    start = 0
                    end = col - 1
                    print(start, end)
                    
                    while start <= end :
                        
                        mid = (start + end) //2
                        
                        # target at middle of the row 
                        if matrix[i][mid] == target :
                            return True
                        
                        # Right subregion
                        elif matrix[i][mid] < target :
                            start = mid + 1
                            
                        # Left subregion
                        else :
                            end = mid - 1
        return False