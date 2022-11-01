#time complexity: O(log(m*n))n=no.of rows, m=no.of columns
#space complexity: O(1)
#run on leetcode: yes
# For the soltuion we use binary seearch. We imagine the 2D matrix to be extended into a single 1D matrix. When 
# we get mid index we manipulate it to get an index into the actual 2D array to perform comparisions with target value

class Solution:
    def searchMatrix(self, matrix,target):
        n=len(matrix)#no.of rows
        m=len(matrix[0]) #no.of cols
        low=0
        high=n*m-1
        while(low<=high):
            mid=(low+high)//2
            r=mid//m
            c=mid%m
            if(matrix[r][c]==target):
                return True
            if(target>matrix[r][c]):
                low=mid+1
            else:
                high=mid-1
        return False

arr=[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
s=Solution()
print(s.searchMatrix(arr,62))
