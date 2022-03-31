//time - O(m log n)
//space - O(1)

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0; i<matrix.length; i++){

            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]){

                int[] array = matrix[i];

                int low = 0, high = matrix[i].length-1;

                while(low <= high){

                    int mid = (high+low)/2;

                    if(array[mid] == target) return true;

                    else if(array[mid] < target) low = mid+1;

                    else high = mid-1;
                }
            }
        }
        return false;
    }
}