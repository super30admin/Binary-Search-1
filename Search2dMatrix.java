//
//
// input = m*n;
// Time Complexity: O(m + n)
//Space Complexity: O(1)

//Pocess:: I have checked every row last of row and if target is less than last element of that particular row then check that particukar row;

public  class Search2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowIndex=0; int columnIndex = matrix[0].length-1;

        while(rowIndex<matrix.length && columnIndex>=0){

            if(matrix[rowIndex][columnIndex] == target) return true;

            else if (matrix[rowIndex][columnIndex] > target) columnIndex--;

            else rowIndex++;
        }

        return false;
    }
    public static void main(String[] args) {

        System.out.println(Search2dMatrix(new int[][]{[1,2,3],[4,5,6]}, target));
    }
}