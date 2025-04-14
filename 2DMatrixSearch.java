public boolean 2DMatrixSearch (int [][] matrix, int target){
    int l = 0;
    int h = matrix.length - 1;
    while (l <= h){
        int mid = l + (h - l)/2;
        if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target){
            return searchRow(matrix[mid], target);
        }
        else if (matrix[mid][0] > target){
            h = mid - 1;
        }
        else{
            l = mid + 1;
        }
    }
    return false;
}

public boolean searchRow(int[] row, int target){
    int l = 0;
    int h = row.length - 1;
    while (l <= h){
        int mid = l + (h - l)/2;
        if (row[mid] == target){
            return true;
        }
        else if (row[mid] > target){
            h = mid - 1;
        }
        else{
            l = mid + 1;
        }
    }
    return false;
}
    
}
