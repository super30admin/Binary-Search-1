#Time Complexity : O(n) - not sure as there's another loop in the if block
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No






class Solution:
  
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #appending an element at the end of the nested list to handle an edge case -> matrix = [[1]], target = 1 
        #as there is no list at index 1, target=1 won't be checked.
        matrix.append([100000])
        #iterating over matrix
        for i in range(len(matrix)):
            #compare the value at 0th index of all nested list -> if the value at 0th index is greater than target then iterate over previous nested list.
            #else check the value for 0th index in the next nested list
           
            if target < matrix[i][0]:
                
                for j in range(len(matrix[i-1])):
                    
                    if target == matrix[i-1][j]:
                        return True
        
        return False
      
