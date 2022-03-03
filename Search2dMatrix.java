class Search2dMatrix {	
	/**Time O(k)| O(1) ; where k is max(rows,cols)**/
	public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;      
        //Find row where the element can exist
        for(int i=0; i<matrix.length; i++){
            if(target <= matrix[i][matrix[0].length-1]) {
            	row=i;
            	break;
            }
        }     
        //Find element in row
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[row][j]==target){
                return true;
            }
        }        
        return false;
    }
}
