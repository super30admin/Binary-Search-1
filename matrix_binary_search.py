class Solution:
    def column_search(self, arr, t):
        l=0
        h=len(arr)-1
        while(l<=h):
            mid = l+(h-l)//2
            if(arr[mid]==t):
                return mid
            if(arr[mid]>t):
                h=mid-1
            else:
                l=mid+1
        return h

    def row_search(self, arr, t):
        l=0
        h=len(arr)-1
        while(l<=h):
            mid=l+(h-l)//2
            if(arr[mid]==t):
                return True
            if(arr[mid]<t):
                l=mid+1
            else:
                h=mid-1
        return False
            

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        col_index=self.column_search([i[0] for i in matrix], target)
        if(matrix[col_index][0]==target):
            return True
        element=self.row_search(matrix[col_index][:], target)
        return element