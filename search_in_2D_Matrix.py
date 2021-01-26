// Time Complexity : O(log n) where n is the number of all elements in 2d array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//  Since the 2d array is sorted this solution uses Binary Search to find of elem is 
// present or not. We access the elements of 2d matrix by assuming it to be a 1D array and use the '%' & '/' formula to 
// map the index in 1d array to index in 2d array.



class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        arr_len = len(matrix) * len(matrix[0])
        
        low = 0
        high = arr_len - 1
        
        while(low<=high):
            mid = low + (high - low)//2
            
            mid_elem = matrix[mid // len(matrix[0])][mid%len(matrix[0])]
            
            if(target == mid_elem):
                return(True)
            elif(target > mid_elem):
                low = mid + 1
            
            else:
                high = mid - 1
        
        return(False)
    
            
             