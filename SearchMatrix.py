#Time Complexity - o(logm*n)
#Did this code successfully run on Leetcode : Yes


class Solution:

    def binary_search(self, row:List[int], l:int, r:int, target)-> int:

        while l<=r:
            m = (l+r)//2
            if row[m]==target:
                return True
            if row[m]<target:
                l = m + 1
            else:
                r = m - 1
        return False

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        
        l = 0
        r = len(matrix)-1

        while l<=r:
            m = (l+r)//2
            row = matrix[m]
            if row[0]<=target<=row[-1]:
                return self.binary_search(row,0,len(row)-1,target)
            if target<row[0]:
                r = m - 1
            else:
                l = m + 1


        return False



