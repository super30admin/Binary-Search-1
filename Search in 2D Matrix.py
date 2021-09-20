class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n=len(matrix)
        m=len(matrix[0])
        low=0
        high=n*m-1
        while(low<=high):
            mid=int(low+((high-low)/2))
            i=int(mid//m)
            j=int(mid%m)
            val=matrix[i][j]
            # print(val)
            if(val==target):
                return True
            else:
                if (val<target):
                    low=mid+1
                else:
                    high=mid-1
        return False