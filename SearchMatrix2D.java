//the 2d array is in sorted order
//2d array into a array visualization
//using the concept of hashset, dividing and mod on the column and row length
//performing a binary search

class SearchMatrix2D{
    
    public static void main(String[] args)
    {
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean result = Matrixsearch(matrix, target);
        System.out.println("Result: " + result);
    }

    //Time Complexity : O(log n) since we are able to get rid of half of the search space
    //Space Complexity: O(1)
    public static boolean Matrixsearch(int[][] matrix, int target){

        if(matrix.length == 0) return false;

        int m = matrix.length; 
        int n = matrix[0].length;  
        int low = 0;
        int high = (m*n)-1; 

        while(low<=high)
        {
            int mid = low + (high - low)/2; 

            int r = mid/n;
            int c = mid%n;

            if(matrix[r][c] == target)
            { 
                return true;
            }
            else
            if(matrix[r][c]>target)
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }

        }

    return false;

    }
}