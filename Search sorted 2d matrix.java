Time complexity: O(log(mn))
Space complexity: O(1)

class Solution { //performing binary search operation
    public boolean searchMatrix(int[][] matrix, int target) {
           if(matrix==null || matrix.length==0 || matrix[0].length==0) //initial check
            return false;
 
        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns
 
        int start = 0; //initialising start pointer to 0
        int end = m*n-1; //end pointer to last element
 
        while(start<=end){ 
            int mid=(start+end)/2; //initialising a mid pointer in between
            int midX=mid/n; //midX to mid/number of columns
            int midY=mid%n; //midY to mid%number of columns
 
            if(matrix[midX][midY]==target)  //if the current element is equal to target, then returning true
                return true;
 
            if(matrix[midX][midY]<target){ //if the current element is less tham target, then moving start pointer to mid+1
                start=mid+1;
            }else{
                end=mid-1; //else moving end pointer to mid-1
            }
        }
        return false;
        }
    }