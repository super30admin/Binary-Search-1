// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class search2DMatrix {
    public boolean search(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int low=0;
        int high = m*n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/n;
            int col=mid%n;
            if(target == matrix[row][col]){
                return true;
            }
            else if(target < matrix[row][col]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
            return false;
    }
     public static void main(String[] args) {
        search2DMatrix mm = new search2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        System.out.println(mm.search(matrix,3)); // ans=true
        System.out.println(mm.search(matrix,13)); // ans=false
    }
}