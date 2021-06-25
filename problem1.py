#time comp- O(logmn) m=number of rows , n=number os columns
#space comp- O(1) no space used
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r=len(matrix)
        c=len(matrix[0])
        l=0
        h=(c*r)-1
        while l<=h:
            mid=((l+h)//2)
            print(mid)
            r1=(mid//c)
            c1=(mid%c)
            val=matrix[r1][c1]
            if val==target:
                return True
            elif val<target:
                l=mid+1
            else:
                h=mid-1
        return False
    
    
