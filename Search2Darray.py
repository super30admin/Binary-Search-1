class Solution:
    def searchMatrix(self, matrix, target):
        rows, cols = len(matrix), len(matrix[0])
        top, bottom = 0, rows-1
        while top<=bottom:
            row = (top+bottom)//2
            if target>matrix[row][-1]:
                top = row+1

                print("top:",top)
            elif target<matrix[row][0]:
                bottom = row-1
                print("bottom:", bottom)
            else:
                break
        if not top<=bottom:
            return False
        
        row = top+bottom//2
        print(row)
        l,r = 0, cols-1
        while(l<=r):
            m = l+r//2
            if target>matrix[row][m]:
                l = m+1
            elif target<matrix[row][m]:
                r = m-1
            else:
                return True
        return False

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
obj = Solution()
print(obj.searchMatrix(matrix, 23))