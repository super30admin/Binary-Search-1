//TC: O(logn)
//SC: O(1)

//code
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
  n=len(matrix) //number of rows
  m=len(matrix[0]) //number of columns

  low=0
  high=n*m-1 //the total number of elements in the matrix

  while(low<=high):
      mid=low+(high-low)//2

      i=mid//m 
      j=mid%m 

      if(matrix[i][j] == target):
          return True
      elif(matrix[i][j] < target):
          low = mid+1
      else:
          high=mid-1

  return False
