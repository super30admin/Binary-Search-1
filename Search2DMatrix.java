/*
Time Complexity = O(logn)
* */

class Search2DMatrix{


        public int findRow (int[][] matrix, int target){

            int rows = matrix.length;
            int i;

            for (i = 0 ; i < rows-1 ; i++)
            {
                if (matrix[i][0] == target || matrix[i+1][0] > target ){
                    //System.out.println(i);
                    return i;
                }


            }
            return i;
        }




        public boolean searchMatrix(int[][] matrix, int target) {

            int totalRows = matrix.length;
            int row;
            if (totalRows == 0)
            {
                return false;
            }
            if (totalRows == 1)
            {
                row = 0;
            }
            else {
                row = findRow(matrix , target );
            }


            int low = 0 ;
            int high = matrix[row].length-1 ;
            while (low <= high ) {
                int mid = low + (high-low)/2;
                //System.out.println("mid : "+mid);
                if(target==matrix[row][mid])
                {
                    return true;
                }
                else if (target < matrix[row][mid])
                {
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            return false;
        }

}