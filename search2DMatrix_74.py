#TimeComplexity: log(MN) 
#SpaceComplexity: O(1)
#It successfully runs on leetcode

def searchMatrix(matrix,target):
        if not matrix: return None
        m=len(matrix)
        n=len(matrix[0])
        low=0
        high=(m*n)-1
        while low<=high:
            mid=low+(high-low)//2
            if matrix[mid//n][mid%n]==target:
                return True
            elif matrix[mid//n][mid%n]<target:
                low=mid+1
            else:
                high=mid-1
        return False

    #Time complexity m+log(n) solution
        # row=0
        # for i in range(len(matrix)):
        #     if i!=len(matrix)-1 and matrix[i][-1]<target:
        #         row+=1
        
        # l=0
        # h=len(matrix[0])-1
        # while l<=h:
        #     m=l+(h-l)//2
        #     if matrix[row][m]==target:
        #         return True
        #     if matrix[row][m]<=target:
        #         l=m+1
        #     else:
        #         h=m-1
        # return False



print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3))