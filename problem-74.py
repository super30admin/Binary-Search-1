class Solution(object):
    
    def decide_factor(self, arr, target, low, high):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        print('..')
        if(high>=low):
            
            mid = (low + high) // 2
            
            if(arr[mid] == target):
                
                return True
            
            elif(arr[mid] > target):
                
                return self.decide_factor(arr, target, low, mid-1)
            
            else:
                
                return self.decide_factor(arr, target, mid+1, high)

        return False
    
    def searchMatrix(self,matrix, target):
        
        m = len(matrix)
        
        n = len(matrix[0])
        
        for i in range(0, m):

            print(matrix[i][0] < target and matrix[i][n-1] > target)
            
            if(matrix[i][0] < target and matrix[i][n-1] > target):

                print(matrix[i])
                print
                return self.decide_factor(matrix[i], target, 0, n-1)

matrix = [[1]]
target = 1

sol= Solution()
print(sol.searchMatrix(matrix, target))