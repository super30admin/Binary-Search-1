
// Time Complexity : O(logmn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

class searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

                int rows = matrix.length;
                int columns = matrix[0].length;
                int end = (rows * columns) - 1;
                int start = 0;

                while(start <= end){

                    int mid =  (start + end) / 2;

                    int row = mid / columns;
                    int col = mid % columns;

                    if (matrix[row][col] == target){
                        return true;
                    }

                    if (matrix[row][col] < target){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
                return false;
            }




    public static void main(String [] args) {
            int [][] nums = new int[3][4];

            nums[0][0] = 1;
            nums[0][1] = 3;
            nums[0][2] = 5;
            nums[0][3] = 7;

            nums[1][0] = 3;
            nums[1][1] = 11;
            nums[1][2] = 16;
            nums[1][3] = 20;

            nums[2][0] = 23;
            nums[2][1] = 30;
            nums[2][2] = 34;
            nums[2][3] = 60;

            searchMatrix obj = new searchMatrix();
            System.out.println("Result is: "+obj.searchMatrix(nums,11));
    }
}