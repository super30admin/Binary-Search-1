//Way 1
//Linear Traversal
//TC: O(m*n); SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }

        return false;
    }
}

//Way 2
//Travel every row. Check last element. If last element is less than or equal to target, check that respective row. If target is found, return true.
//TC: O(m+n); SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++){
            if(target<=matrix[i][n-1]){

                for(int j=0;j<n;j++){
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }
}

//Way 3
//Consider matrix as imaginary sorted array. Perform binary search on it and convert the mid to it's respective row and col. Check whether element at position is target or not and continue the binary search
//TC: log m+log n; SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int low=0,high=m*n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int r=mid/n;
            int c=mid%n;
        
            if(matrix[r][c]==target){
                return true;
            }else if(matrix[r][c]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return false;

    }
}

//way 4
//Identify the row using binary search. Identify the presence of target in that row using binary saerch
//TC: log m+log n; SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        //Identify row:
        int l=0,h=m-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(matrix[mid][n-1]==target){
                return true;
            } else if(matrix[mid][n-1]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }

        if(l>=m) return false;

        return binarySearch(matrix[l],target);

    }

    private boolean binarySearch(int[] row,int target){
        int low=0,high=row.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(row[mid]==target){
                return true;
            }else if(row[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;
    }
}
