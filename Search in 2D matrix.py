#time complexity- o(log(m)+log(n)) and space complexity - o(1)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])-1
        a=0
        b=m-1

        while a<=b:
            row=(a+b)//2

            if target>matrix[row][-1]:
                a=row+1
            elif target<matrix[row][0]:
                b=row-1
            else:
                l=0
                h=n
                while l<=h:
                    mid=(l+h)//2
                    if target==matrix[row][mid]:
                        return True
                    elif target>matrix[row][mid]:
                        l=mid+1
                    else:
                        h=mid-1
                return False
        return False