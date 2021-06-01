class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lowR = 0;
        int lowC = 0;
        int highR = matrix.length-1;
        int highC = matrix[0].length-1;



        while(lowR<=highR && lowC<=highC){
            if (lowC!=highC){
                int mid = lowC + (highC-lowC)/2;
                if( matrix[lowR][mid] == target){
                    return true;
                }
                else if(matrix[lowR][mid] < target){
                    lowC = mid + 1;
                }
                else{
                    highC = mid - 1;
                }
            }
            else{
                int mid = lowR + (highR-lowR)/2;
                System.out.println(highR +" "+ lowR +" "+ mid);
                if(matrix[mid][lowC] == target){
                    return true;
                }
                else if(matrix[mid][lowC] < target){
                    lowR = mid + 1;
                }
                else{
                    highR = mid - 1;
                }
            }
        }
        return false;
    }


}