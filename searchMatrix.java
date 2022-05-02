//time complexity:O(logmn)
//space complexity:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n -1;
        while(low<=high){
            int mid=low + (high-low)/2;
            int midElem=matrix[mid/n][mid%n];
            if(midElem == target) {
                return true;
            }
            else if(midElem>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
