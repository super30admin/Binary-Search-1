class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if (len(matrix) == 0 or matrix == None ):
            
            return False
        self.m = len(matrix)
        self.n = len(matrix[0])
        self.low = 0
        self.high = (self.m * self.n) - 1
        while(self.low <= self.high):
            self.mid = self.low + self.high - self.low /2
            row = int(self.mid / self.n)
            print(row)
            column = int(self.mid % self.n)
            print(column)
            if(matrix[row][column] == target):
                
                return True
            elif(target < matrix[row][column]):
                self.high = self.mid - 1
            else:
                self.low = self.mid + 1
            
        return False
        
        