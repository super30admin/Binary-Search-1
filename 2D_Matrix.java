// 74. Search a 2D Matrix - https://leetcode.com/problems/search-a-2d-matrix/
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to think.

class Solution {
    public boolean searchMatrix(int[][] a, int t) 
    {
        int n = a.length;
        int m = a[0].length;
        int L=0;
        int H=(m*n)-1; // 2-D array
        while(L<H){
            int M = L+(H-L)/2;
            int i = M/m;
            int j = M%m;    
            //System.out.println(i+" | "+j);
            if(a[i][j]==t)
            {
                return true;
            }
            if(a[i][j]>t)
            {
                H=M-1;
            }
            if(a[i][j]<t)
            {
                L=M+1;
            }
    }
        if(L==H) // if only one element is inserted
        {
            if(a[L/m][L%m]==t)
            {
                return true;
            }
        }
        return false;
    }
}