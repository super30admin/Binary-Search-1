#Time Complexity = O(nlogm)
#space complexity = O(1)

class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        
        
        # we need 2 pointers 1 on top of row one on last row
        top,bottom = 0,rows-1
        
        #run binary search to select the row where to find target
        while top<=bottom:
            midrow = (top+bottom)//2
            if target > matrix[midrow][-1]:
                top = midrow +1
            elif target < matrix[midrow][0]:
                bottom = midrow -1
            else:
                break
            
        # from BS1 once row is selected we need BS to search for  target in that row
        
        if not (top<=bottom):
            return False
        
        # select the mid of the row where we need to sarch target
        mid = (top + bottom) //2
        
        # Assign left and right pointers in that row
        l,r = 0, cols-1
        
        # Doing binary search on that row to get the target
        while l<=r:
            m = (l+r) //2
            if target > matrix[mid][m]:
                l = m+1
            elif target < matrix[mid][m]:
                r = m-1
            else:
                return True
        return False
    