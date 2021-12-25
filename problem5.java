// Time Complexity : O(n)
// Space Complexity :O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : the first run exceeded the time complexity required, on refactering the code required time complerxity was achived


// Your code here along with comments explaining your approach

/**@approach : Saddelback Search Algorithm
 * goto the top rigt element of the matrix
 * if it is equal to the serach element return true
 * if search element is smaller than current element move back in row 
 * else move down and repeat abovew step
 * if element not found return false elase true
 */

class Solution {

    public boolean search(int [][]matrix,int rows,int cols,int target){
        int x = cols-1;
        int y = 0;
        while(y<rows && x>=0){
            if(matrix[y][x] == target){
                return true;
            }
            if(matrix[y][x]>target){
                x--;
            }
            else{
                y++;
            }
        } 
        return false;
        
    }



    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean found = search(matrix,rows,cols,target);
        return found;

    }
}