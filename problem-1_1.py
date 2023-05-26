#Time complexity is O(log(m*n)) where m is the no of rows and n is no of columns
#Space complexity is O(1)
#Program ran successfully on leetcode
#Faced no problem while coding

class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        #here we are taking the initial counts of rows and columns
        self.rows=len(matrix)
        self.cols=len(matrix[0])
        #checking whther the matrix is empty or not
        if(self.rows==0 and self.cols==0):
            return
        #if the matrix is not empty
        else:
            #taking initial value of left to 0 and right to maximum index
            self.left=0
            self.right=self.rows*self.cols-1
            while(self.left<=self.right):
                #here we are calculating the mid value
                self.mid=(self.left+self.right)//2
                #based on the mid value we will be calculating row and column number
                self.row=self.mid//self.cols
                self.column=self.mid%self.cols
                #if the value in the matrix matches the target we will return true
                if(matrix[self.row][self.column]==target):
                    return True
                #if the value is less than target we will change the left value or else right value
                elif(matrix[self.row][self.column]<target):
                    self.left=self.mid+1
                else:
                    self.right=self.mid-1
            #if the vaue is not found we will return false
            return False