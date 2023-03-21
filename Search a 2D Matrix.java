class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //This iis going to be a little different type of search.@interface

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while(left <= right){

            //mid is calculated differently. 
            int mid = left + (right - left) / 2;

            int mid_element = matrix[mid/ n][mid % n];

            if(target == mid_element){
                return true;
            }

            if(target < mid_element){
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }




        }

        return false;
    }

    
}