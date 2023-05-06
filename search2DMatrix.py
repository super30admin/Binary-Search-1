'''
Leet Code: https://leetcode.com/problems/search-a-2d-matrix/
'''

class Solution:
    
    def binarySearch(self,arr,low,high,target):
        
        if low > high:
            return False
        
        # Find the mid
        mid = (high-low)//2 + low
        
        # Perform check
        if target == arr[mid]:
            return True
        
        elif target < arr[mid]:
            return self.binarySearch(arr,low,mid-1,target)
        
        else:
            return self.binarySearch(arr,mid+1,high,target)        
    
    def searchMatrix(self, matrix, target: int) -> bool:
        
        '''
        print('m is:\t',len(matrix))
        print('n is:\t',len(matrix[0]))
        '''
        
        # Return the result
        rtrResult = False
        
        # Iterate the matrix
        for itr in range(0,len(matrix)):
            
            '''
            print('Test 1:\t',matrix[itr][0])
            print('Test 1:\t',matrix[itr][len(matrix[itr])-1])
            '''
            
            # Perform check if "target" lies in range
            if matrix[itr][0] <= target <= matrix[itr][len(matrix[itr])-1]:
                # Perform Binary Search
                rtrResult = self.binarySearch(matrix[itr],0,len(matrix[itr])-1,target)
                
                # Check if the result it True
                if rtrResult == True:
                    break
                    
            continue
        
        return rtrResult
        
        '''
        
        print('Matrix is:\t',matrix)
        print(matrix[0][0])
        
        '''