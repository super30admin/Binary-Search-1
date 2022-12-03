// Time Complexity : O(logn) used binary search 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO ( failed for similar/duplicate values [[1,1]])
// Any problem you faced while coding this : (
    
// DOUBTS:
    //Help me find the solution for duplicate values if possible)
    // Also BS takes logn but I was comparing the last element of each row, I have doubt reagrding the TC of this comparision.

// DESCRIPTION: Used Binary search for a row by comparing the last elememt of row with the target if(target < matrix[i][n-1]) 
// and performing the binary search for that particular row only.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        System.out.println(m);
        int n = matrix[0].length;
        if(n==1 && matrix[0][0]==target)
            return true;
        else if(n==1 && matrix[0][0]!=target)
            return false;
        int i=0;
        int low = 0;
        int high = n-1;
        int value=-1;
        while(i<m){
            if(target < matrix[i][n-1])
            {value =  BS(matrix,i,high,target);
            break;
            }
            i++;
        }
        if(value==-1)
            return false;
        return true;
        
    }
    
    public int BS(int[][] matrix, int low, int high, int target){
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (target == matrix[low][mid])
            return mid;
        if (target > matrix[low][mid])
            return BS(matrix, (mid + 1), high, target);
        return BS(matrix, low, (mid - 1), target);
    }
}
