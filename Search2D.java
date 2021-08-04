//Time Complexity - O(m) where m is length of matrix
//Space Complexity - O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length ==0){
            return false;
        }
        int col = matrix.length;
        int row = matrix[0].length-1;
        //int totalElements = col * row;
        //System.out.println(totalElements);
        //[0,0][0,1][0,2][0,3[1,0][1,1][1,2][1,3][2,0][2,1][2,2][2,3]
        for (int i=0;i<col;i++){
            int index = matrix[i][row];
            System.out.println(index);
            if (target == index){
                return true;
            }
            else if (target<index){
                return binarySearch(matrix[i],target,row);
            }
        }
        
        //how can we halve the search space
        return false;
        
    }
    public boolean binarySearch(int[] elements,int target,int high){
        int low = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (target==elements[mid]){
                return true;
            }
            else if (target>elements[mid]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
    }
}