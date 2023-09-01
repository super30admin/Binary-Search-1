class Matrix_Search_2D {
    //To search an element in log time, we'll use Binary search. For Binary search array should be sorted.
    //Given 2D array in which last element of the row is smaller than the first element of the next row
    //Time complexity of this algorithm will be O(log m*n), where m*n is the size of the array.
    //Space complexity will be O(1), because we are storing in 2D array
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0){  //Base case to check if matrix is empty and return if it is empty
            return false;
        }
        int m = matrix.length;  //this will give the length of each row.
        int n = matrix[0].length; //this will give the length of each column.
        int low = 0;  //lower bound of the array.
        int high = m * n - 1;  //upper bound of the array.


        while(low <= high){
            // int mid=(low+high)/2;  //This will the index of middle element.
            int mid= low+(high-low)/2;  //other way to get the index of middle element to avoid the situtation of
            // index overflow where the value goes out of the range.
            int row = mid/n;    // to get the row number of the element in 2D array, where n is the total no. of
            //columns in 2D array
            int col = mid%n;   //to get the col number of the element in the 2D array, where n is the total number
            // of columns in 2D array
            if (matrix[row][col]==target){  //Condn to check if target is equal to middle element.
                return true;  //If yes then return true
            }
            else if(target> matrix[row][col]){  //Condn to check if target is greater than middle element.
                low =mid+1;                //If yes, then target must be on the right hand side of the array.Therefore, low will become mid+1.
            }
            else{                           //If target is smaller than the middle element, this means element lies on th left side of the array and high will change to mid-1
                high = mid-1;
            }
        }
        return false;      //If element is not found in the array, then return false
    }

    public static void main(String[] args){
        Matrix_Search_2D  m= new Matrix_Search_2D();
        int[][] matrix= {{1,2,3},{10,11,16,20},{23,30,34,60}};
        int target= 3;
        System.out.println(m.searchMatrix(matrix,target));
    }
}