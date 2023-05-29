#time complexity: O(log m*n)
#Did the code run in leetcode: Yess the code passed all the test cases.
#Did you face any problem: No


class Solution:

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        #This method is very similart to binary search but this binary search happens in 2d array.
        for i in range(len(matrix)):
            l=0
            h=len(matrix[i])-1
            while l<=h:
                mid=l+(h-l)//2
                #Compare matrix and check if its equal item
                if(matrix[i][mid]==target):
                  return True
                #Check if the number is less than the target.
                elif (matrix[i][mid]<target):
                  l=mid+1
                else:
                   h=mid-1
        return False
                
                    

