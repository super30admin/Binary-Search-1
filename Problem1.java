//Executed on leetcode
//Took multiple wrong approches i was making 2-3 functions and going in never ending recursion but later thougt i can consider all matrix as one array and play with indices did it and worked
//Time O(mxn)


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int h = (matrix[0].length * (matrix.length)) -1;
       return arrayfinder(matrix, l,h, target);
        

    }

    boolean arrayfinder (int[][] matrix, int l, int h, int x) {
        while (l <= h && h>=0) {

            int mid = l + (h-l)/2;
            int idx1 = mid / matrix[0].length ;
            int idx2 = mid % matrix[0].length;

            if(matrix[idx1][idx2]==x){
                return true;
            }
            else if(matrix[idx1][idx2]>x){
                return arrayfinder(matrix,l,mid-1,x);
            }
            else{
                return arrayfinder(matrix,mid+1,h,x);
            }

        }
        return false;

    }


  
}
